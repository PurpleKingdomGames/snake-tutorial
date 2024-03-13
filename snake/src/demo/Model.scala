package demo

import indigo.*
import demo.generated.Assets

final case class Model(
    apple: Point,
    snake: Batch[Point],
    size: Size,
    lastUpdated: Seconds,
    direction: Direction
):

  def update(context: FrameContext[Unit]): GlobalEvent => Outcome[Model] =
    case KeyboardEvent.KeyUp(Key.UP_ARROW) if direction != Direction.Down =>
      Outcome(this.copy(direction = Direction.Up))

    case KeyboardEvent.KeyUp(Key.DOWN_ARROW) if direction != Direction.Up =>
      Outcome(this.copy(direction = Direction.Down))

    case KeyboardEvent.KeyUp(Key.LEFT_ARROW) if direction != Direction.Right =>
      Outcome(this.copy(direction = Direction.Left))

    case KeyboardEvent.KeyUp(Key.RIGHT_ARROW) if direction != Direction.Left =>
      Outcome(this.copy(direction = Direction.Right))

    case FrameTick if (context.running - lastUpdated).toMillis >= Millis(100) =>
      val proposed =
        snake.headOption match
          case None =>
            // Should never happen.
            Point.zero

          case Some(h) =>
            h + direction.relativePosition

      val next =
        Point(
          x = Math.floorMod(proposed.x, size.width),
          y = Math.floorMod(proposed.y, size.height)
        )

      if snake.dropRight(1).exists(_ == next) then
        Outcome(
          this.copy(
            snake = Model.initial.snake,
            direction = Model.initial.direction,
            lastUpdated = context.running
          )
        ).addGlobalEvents(Assets.assets.losePlay)
      else if next == apple then
        Outcome(
          this.copy(
            snake = next :: snake,
            lastUpdated = context.running,
            apple = Point(
              x = context.dice.rollFromZero(size.width),
              y = context.dice.rollFromZero(size.height)
            )
          )
        ).addGlobalEvents(Assets.assets.pointPlay)
      else
        Outcome(
          this.copy(
            snake = next :: snake.dropRight(1),
            lastUpdated = context.running
          )
        )

    case _ =>
      Outcome(this)

object Model:
  val initial: Model =
    Model(
      apple = Point(1, 1),
      snake = Batch(Point(6, 6), Point(6, 6), Point(6, 6)),
      size = Size(12),
      lastUpdated = Seconds.zero,
      direction = Direction.Up
    )

enum Direction:
  case Up
  case Down
  case Left
  case Right

  def relativePosition: Point =
    this match
      case Up    => Point(0, -1)
      case Down  => Point(0, 1)
      case Left  => Point(-1, 0)
      case Right => Point(1, 0)
