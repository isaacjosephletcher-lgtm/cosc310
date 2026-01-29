# Copilot / AI agent instructions for this repository

Short, actionable guidance so an AI coding agent can be immediately productive working on these COSC 310 course labs.

1. Big picture
- This repo is a set of small Java lab programs organized by chapter. Each chapter folder (e.g. `chapter6`, `chapter8`, `review`) is its package and contains related `.java` files. Classes declare `package chapter6;` etc., so treat folder paths as package roots.
- The primary bench/driver in chapter 6 is `chapter6.ArrayVsArrayListLab` which exercises a `Target` abstraction to measure timings; results are written to `results.csv`.

2. Typical data flows and why they matter
- Input: `numbers.txt` (workspace root) -> read by `chapter6.DataLoader` into either a primitive `int[]` or `ArrayList<Integer>`.
- Benchmark: `chapter6.Target.runTests(...)` times the `method(...)` implementation using `System.nanoTime()` and the `TRIALS` constant.
- Output: CSV written by `Target.writeResults(PrintWriter)` to `results.csv` (created in workspace root). Keep I/O separate from timing (DataLoader already follows this).

3. Build / run / debug (explicit examples)
- From repo root, compile all packages (writes .class files into directory structure):

```
javac -d . chapter6/*.java chapter8/*.java review/*.java
```

- Run the main driver (example):

```
java chapter6.ArrayVsArrayListLab
```

- Notes: because files declare packages, always run compile/run from repository root. `-d .` ensures class files are placed according to package paths. No build system (Maven/Gradle) is present.

4. Project-specific conventions and patterns
- Package-per-folder: each top-level folder corresponds to a package (do not move files out of their folders). Example: `chapter6/Target.java` is `chapter6.Target`.
- Benchmark pattern: implement `method(int[])` in subclasses of `Target`, rely on `runTests` for timing; the `name` field encodes a CSV-friendly label (example: `"array,random_access"`). Keep that format when adding new `Target` subclasses.
- Prefer primitive `int[]` for fair performance comparisons (see `DataLoader.loadArray`).
- Numeric literals sometimes use underscores (e.g. `15_000`); keep them when editing for readability.

5. Integration points / things that break compile
- `DataLoader` expects `numbers.txt` in the repository root; missing file causes IO exceptions at runtime.
- Several lab files may contain deliberate placeholders or incomplete code (e.g. `ArrayVsArrayListLab` contains `...` placeholders). Do not auto-fix or fill those in without confirmation from the user — treat them as student TODOs.

6. Files to inspect first when asked to modify behavior
- `chapter6/ArrayVsArrayListLab.java` — main benchmarking orchestration and example of how targets are instantiated.
- `chapter6/DataLoader.java` — input parsing and important note about primitive arrays vs. collections.
- `chapter6/Target.java` — timing harness, `TRIALS` constant, CSV output format.
- `chapter6/*` — other `Array*` and `List*` classes implement `Target.method`.
- `chapter8/Banner.java` — small example driver using `chapter8` classes.

7. Safe default actions for an AI agent
- When asked to run or test: compile with `javac -d . ...` and run the fully qualified class name. Report compiler errors rather than guessing fixes.
- When asked to add or change benchmarks: follow the `Target` API (override `method(int[])`) and use `name` strings in CSV-friendly format.
- Do not change package declarations or move files between folders.

8. Questions to ask the user before non-trivial edits
- Should missing test scaffolding or placeholder `...` code be implemented, or do you want hints and a TODO list instead?
- Should I add a minimal build script (`Makefile` or simple shell script) to standardize compile/run commands?

If anything above is unclear or you'd like a different level of detail (examples of fixing a specific lab, or adding a build script), tell me which part to expand.
