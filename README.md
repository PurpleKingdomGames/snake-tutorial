# Snake Tutorial

This repository accompanies a video tutorial available on YouTube called [Let's build Snake!](https://www.youtube.com/watch?v=YJtG5E_a9sw), and contains the completed code.

To run the game as seen in the tutorial, please run `yarn install` or `npm install` from the root directory (where `package.json` is located).

As in the tutorial, if you'd like to start from scratch, please use [Indigo's Giter8 template](https://github.com/PurpleKingdomGames/indigo.g8).

> Please note that this repo contains Nix flake files. If you're not a Nix user, you can safely ignore / delete them.

This repo additionally contains a pre-compiled static website version of the game in the `docs` directory, which is served up by ghpages. It is the result of running `./mill snake.buildGameFull` and copying the output into the docs directory.

You can play the game in three ways:

1. Play online: [https://purplekingdomgames.github.io/snake-tutorial/](https://purplekingdomgames.github.io/snake-tutorial/)
2. Running it yourself as in the tutorial: `./mill snake.runGame`
3. Via a local web server:
   1. `yarn install`
   2. `cd docs`
   3. `npx http-server -c-1`
   4. Visit [http://localhost:8080](http://localhost:8080), or whatever the output of the previous command says is the correct address.

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
