package demo

import indigo.*
import indigo.syntax.*
import indigo.scenes.*
import demo.generated.Assets

object GameScene extends Scene[Unit, Model, Unit]:

  type SceneModel     = Model
  type SceneViewModel = Unit

  val name: SceneName =
    SceneName("game")

  val modelLens: Lens[Model, Model] =
    Lens.keepLatest

  val viewModelLens: Lens[Unit, Unit] =
    Lens.keepLatest

  val eventFilters: EventFilters =
    EventFilters.Permissive

  val subSystems: Set[SubSystem] =
    Set()

  def updateModel(
      context: SceneContext[Unit],
      model: Model
  ): GlobalEvent => Outcome[Model] =
    case e =>
      model.update(context.frameContext)(e)

  def updateViewModel(
      context: SceneContext[Unit],
      model: Model,
      viewModel: Unit
  ): GlobalEvent => Outcome[Unit] =
    _ => Outcome(viewModel)

  val apple =
    Graphic(16, 16, Assets.assets.snakeMaterial).withCrop(64, 0, 16, 16)
  val snake =
    Graphic(16, 16, Assets.assets.snakeMaterial).withCrop(16, 0, 16, 16)
  val background =
    Graphic(16, 16, Assets.assets.snakeMaterial).withCrop(48, 0, 16, 16)

  val tiles =
    (0 to 12).toBatch.flatMap { y =>
      (0 to 12).toBatch.map { x =>
        background.moveTo(Point(x, y) * Point(16))
      }
    }

  def present(
      context: SceneContext[Unit],
      model: Model,
      viewModel: Unit
  ): Outcome[SceneUpdateFragment] =
    Outcome(
      SceneUpdateFragment(
        Layer(
          tiles
        ),
        Layer(
          apple.moveTo(model.apple * Point(16))
        ),
        Layer(
          model.snake.map { s =>
            snake.moveTo(s * Point(16))
          }
        )
      )
    )
