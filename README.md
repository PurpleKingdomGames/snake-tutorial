# Snake Tutorial

This repository accompanies a video tutorial available on YouTube, and contains the completed code.

As in the tutorial, if you'd like to start from scratch, please use [Indigo's Giter8 template](https://github.com/PurpleKingdomGames/indigo.g8).

> Please note that this contains Nix flake files. If you're not a Nix user, you can safely ignore / delete them.

Below follows the standard README from the Giter8 template.

---

## Getting started with Mill

The repo contains a version of the [millw](https://github.com/lefou/millw) launch script, so even if you have Mill installed globably, you're advised to use run Mill as `./mill <commands>`.

Below is a list of useful commands, including some generally useful ones in case you're new to Mill.

> Note that if you're using zsh, you may need to surround argument groups with single quotes, if you have special characters like hypens in your project name.

## Quick command aliases

These are defined in the `build.sc` file in this project, they are a combination of other built-in commands

```bash
# Run your game via Electron using fast compilation
./mill snake.runGame

# Run your game via Electron using full compilation and compression
./mill snake.runGameFull

# Build your game as a static website using fast compilation
./mill snake.buildGame

# Build your game as a static website using full compilation and compression
./mill snake.buildGameFull
```

## Basic Mill commands

```bash
# Compile everything
./mill __.compile

# Clean the game project
./mill clean snake

# Compile the game
./mill snake.compile

# Run your game modules tests
./mill snake.test
```

## Scala.js commands

```bash
# Scala.js fast compile (large file size)
./mill snake.fastLinkJS

# Scala.js full compile and compress
./mill snake.fullLinkJS
```

## Indigo commands

```bash
# Build your game as a static website using fast compilation, assumes you have already compiled to Scala.js using fastLinkJS
./mill snake.indigoBuild

# Build your game as a static website using full compilation and compression, assumes you have already compiled to Scala.js using fullLinkJS
./mill snake.indigoBuildFull

# Run your game via Electron using fast compilation, assumes you have already compiled to Scala.js using fastLinkJS
./mill snake.indigoRun

# Run your game via Electron using full compilation and compression, assumes you have already compiled to Scala.js using fullLinkJS
./mill snake.indigoRunFull
```
