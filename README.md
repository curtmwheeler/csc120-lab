# CSC 120 Lab

**University of Miami · CSC 120 (Introduction to Computer Science) · Spring 2026**

This repository contains weekly lab assignments for CSC 120. Each lab focuses on core programming concepts in Java, from basic I/O and arithmetic through methods, classes, and numerical approximation.

---

## Table of Contents

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Repository Structure](#repository-structure)
- [Labs Overview](#labs-overview)
- [Running the Code](#running-the-code)
- [Project Configuration](#project-configuration)
- [License](#license)

---

## Overview

The labs progress from introductory Java (printing, variables, `Scanner` input) to more structured programs (classes, methods, algorithms). Source code lives under each `WEEKn_LABm/src/` directory, and some labs include pseudocode or design documents to support implementation.

---

## Prerequisites

- **Java**: JDK 8 or later (compatible with the course toolchain).
- **IDE** (optional but recommended): IntelliJ IDEA. The repo includes `.iml` module files and `.idea/` configuration for IntelliJ.

You can also compile and run from the command line:

```bash
cd WEEKn_LABm/src
javac *.java
java MainClass
```

Replace `WEEKn_LABm` and `MainClass` with the specific week folder and main class name (e.g. `WEEK3_LAB2`, `LinearEquation`).

---

## Repository Structure

```txt
CSC120_LAB/
├── README.md                 # This file
├── CSC120_LAB.iml            # Root IntelliJ module
├── .gitignore
├── WEEK1_LAB1/               # Week 1 – Lab 1
│   ├── src/
│   └── WEEK1_LAB1.iml
├── WEEK3_LAB2/               # Week 3 – Lab 2
│   ├── src/
│   └── WEEK3_LAB2.iml
├── WEEK4_LAB3/               # Week 4 – Lab 3
│   ├── src/
│   └── WEEK4_LAB3.iml
├── WEEK5_LAB4/               # Week 5 – Lab 4
│   ├── src/
│   └── WEEK5_LAB4.iml
├── WEEK6_LAB5/               # Week 6 – Lab 5
│   ├── src/
│   └── WEEK6_LAB5.iml
└── WEEK7_LAB6/               # Week 7 – Lab 6
    ├── src/
    ├── README.md             # Lab 6 project plan & spec
    └── WEEK7_LAB6.iml
```

---

## Labs Overview

### Week 1 – Lab 1: Introduction to Java

- **Location**: `WEEK1_LAB1/src/`
- **Topics**: First programs, `System.out`, simple output.
- **Files**:
  - `HelloWorld.java` – classic “Hello, World” style program.
  - `Intro.java` – prints a short text introduction (e.g. a friend’s name, age, food, hobby).
  - `Shapes.java` – draws simple ASCII-art letters (e.g. M, S).
  - `Trapezoids.java` – trapezoid-related output or calculations.

### Week 3 – Lab 2: Input and Linear Algebra

- **Location**: `WEEK3_LAB2/src/`
- **Topics**: `Scanner`, variables, arithmetic, formatted output.
- **Files**:
  - `LinearEquation.java` – solves a 2×2 linear system \(ax + by = p\), \(cx + dy = q\) using the determinant method; reads coefficients from the user and prints \(x\) and \(y\).
  - `AndreaBakery.java` – bakery menu (cream puff, eclair, macaron, croissant); reads quantities, computes subtotal, tax, and total.
  - `Practice.java` – additional practice exercises.
- **Design**: `pseudocode_part_2.txt` supports lab design.

### Week 4 – Lab 3: Projectile Motion

- **Location**: `WEEK4_LAB3/src/`
- **Topics**: Constants, multi-step calculations, Earth vs. Moon gravity.
- **Files**:
  - `BallReach.java` – projectile trajectory: given initial height, launch angle, and speed, computes horizontal distance, times, and velocities for both Earth (9.81 m/s²) and Moon (1.62 m/s²) gravity; includes a simple TUI with dividers and formatted output.
  - `BallUpSlope.java` – related ball-on-slope or trajectory variant.
  - `Practice.java` – practice problems.
- **Design**: `pseudocode-part-1.txt`, `pseudocode-part-2.txt` describe the algorithms.

### Week 5 – Lab 4: Classes and BMI

- **Location**: `WEEK5_LAB4/src/`
- **Topics**: Classes, constructors, getters/setters, validation, static methods.
- **Files**:
  - `BMICalculator.java` – BMI calculator class with metric/imperial support, constructors, and input validation.
  - `BMIComparison.java` – reads four people (name, height, weight), computes BMI, and ranks by height, weight, and BMI (e.g. using a “find 1st” style ranking).
  - `Practice.java` – extra practice.
- **Design**: `pseudocode.md` describes class responsibilities and the ranking algorithm.

### Week 6 – Lab 5: Catch the Thief (Grid Game)

- **Location**: `WEEK6_LAB5/src/`
- **Topics**: 2D grid representation, user input, random movement, simple game loop.
- **Files**:
  - `CatchThief.java` – text-based game on a 10×10 grid; player (P) moves with L/R/U/D to catch a thief (T) who moves randomly each turn; uses a `TUI` helper for formatted output.
  - `TUI.java` – shared terminal UI utilities (e.g. viewport width, formatting).

### Week 7 – Lab 6: Taylor Series Approximations

- **Location**: `WEEK7_LAB6/src/`
- **Topics**: Loops, Taylor series, comparison with `Math` library.
- **Files**:
  - `Taylor.java` – intended to implement Taylor approximations for:
    1. \(\sqrt{a + \delta}\)
    2. \(\sqrt[3]{a + \delta}\)
    3. \(\log(1 + \delta)\)
    with user-chosen base, delta, and number of terms; compares results to `Math.sqrt`, `Math.pow`, and `Math.log`.
  - `TUI.java` – TUI for menu and formatted output.
- **Spec**: `WEEK7_LAB6/README.md` contains the full project plan, algorithms, variable tables, formatting rules, test cases, and complexity notes.

---

## Running the Code

1. **IntelliJ IDEA**
   - Open the repo root (or `CSC120_LAB.iml`) as a project.
   - Each `WEEKn_LABm` folder is a module; open the module you need, then run the desired main class (e.g. `LinearEquation`, `BallReach`, `CatchThief`) from the `src` directory.

2. **Command line**
   - Go to the lab’s `src` folder and compile all `.java` files, then run the main class:

   ```bash
   cd WEEK3_LAB2/src
   javac *.java
   java LinearEquation
   ```

   - For labs that use a package or multiple entry points, run the appropriate class (e.g. `java CatchThief`, `java Taylor`).

---

## Project Configuration

- **IDE**: IntelliJ IDEA (`.idea/`, `*.iml`). `.gitignore` excludes build outputs (`out/`, `bin/`), IDE-specific caches, and OS files (e.g. `.DS_Store`).
- **Modules**: One IntelliJ module per lab (`WEEK1_LAB1` through `WEEK7_LAB6`), each with its own `src` directory.

---

## License

This repository is **All Rights Reserved**. See [LICENSE](LICENSE) for full terms.

The code is original coursework and is not licensed for use by others as their own work. Copying, distributing, or submitting this code for credit elsewhere is prohibited and may violate academic integrity policies. The contents of this repo are not endorsed by the University of Miami or its faculty.

---

*CSC 120 Lab – University of Miami, Spring 2026.*
