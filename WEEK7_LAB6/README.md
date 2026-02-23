# CSC 120 – Lab 6 Project Plan

---

## 1. Objective

Implement a Java class `Taylor` that computes Taylor series approximations for:

1. √(a + δ)
2. ∛(a + δ)
3. log(1 + δ)

Where:

* `a > 0`
* `|δ|` is small
* `n` = number of Taylor terms specified by the user

The program must print the approximation at each round and compare it to Java’s built-in `Math` function.

---

## 2. Mathematical Background

The Taylor expansion of a function at `a + δ` is:

[
f(a + \delta) \approx f(a) + \sum_{k=1}^{n} \frac{f^{(k)}(a)\delta^k}{k!}
]

For small `|δ|`, higher-order terms decrease rapidly, improving approximation accuracy.

---

## 3. Program Structure

### Class Design

```java
public class Taylor
```

### Required Methods

* `main(String[] args)`
* `approximateSquareRoot(double base, double delta, int numTerms)`
* `approximateCubicRoot(double base, double delta, int numTerms)`
* `approximateLog(double delta, int numTerms)`

---

## 4. User Interface Requirements

Program must display:

```
Which approximation do you want to compute?
1. Square Root
2. Cubic Root
3. Logarithm
```

### Input Parameters

| Function    | Inputs Required        |
| ----------- | ---------------------- |
| Square root | base (a), delta (δ), n |
| Cubic root  | base (a), delta (δ), n |
| Logarithm   | delta (δ), n           |

---

## 5. Algorithm Design

---

### 5.1 Square Root Approximation

Approximating:

[
\sqrt{a + \delta}
]

#### Variables

| Variable      | Type   | Purpose                |
| ------------- | ------ | ---------------------- |
| base          | double | a                      |
| delta         | double | δ                      |
| approximation | double | running sum            |
| coefficient   | double | derivative coefficient |
| exponent      | double | exponent tracker       |
| power         | double | derivative base term   |
| factorial     | long   | k!                     |
| deltaPower    | double | δ^k                    |
| round         | int    | loop counter           |

#### Initialization

```java
approximation = Math.sqrt(base);
coefficient = 1.0;
exponent = 0.5;
power = approximation;
factorial = 1;
deltaPower = 1.0;
```

#### Iteration Loop (for round = 1 to numTerms)

1. `coefficient *= exponent`
2. `exponent -= 1`
3. `power /= base`
4. `factorial *= round`
5. `deltaPower *= delta`
6. `approximation += coefficient * power * deltaPower / factorial`

Print approximation each round.

---

### 5.2 Cubic Root Approximation

Approximating:

[
\sqrt[3]{a + \delta}
]

Same algorithm as square root with these changes:

* `exponent = 1.0 / 3.0`
* `approximation = Math.pow(base, 1.0 / 3.0)`

Everything else remains identical.

---

### 5.3 Logarithm Approximation

Approximating:

[
\log(1 + \delta)
]

Taylor expansion:

[
\delta - \frac{\delta^2}{2} + \frac{\delta^3}{3} - \frac{\delta^4}{4} + \cdots
]

#### Variables

| Variable      | Type   |
| ------------- | ------ |
| approximation | double |
| deltaPower    | double |
| factorial     | long   |
| round         | int    |

#### Initialization

```java
approximation = 0.0;
deltaPower = 1.0;
factorial = 1;
```

#### Iteration Loop

For round = 1 to numTerms:

1. `deltaPower *= delta`
2. `factorial *= round`
3. `term = deltaPower / factorial`
4. If round is odd → add term
5. If round is even → subtract term

Print approximation each round.

---

## 6. Output Formatting Requirements

Output must match the specification format:

```
---- the square root of 16.00000 + 0.05000 -----
Round=01,approx=4.006250000000000
...
-----------------------------------------------
Expected =4.006245124802026
Approximation=4.006245124802026
```

### Formatting Rules

Use `System.out.printf()`:

* base and delta → 5 decimal places
* approximation → 15 decimal places
* round → 2 digits with leading zero

---

## 7. Edge Case Considerations

* base must be positive for roots
* |delta| should be less than 1 for convergence
* factorial must use `long` (not int)
* Watch for potential overflow if n is large

---

## 8. Testing Plan

### Test Case 1 – Square Root

```
a = 16
delta = 0.05
n = 20
```

Expected comparison:

```
Math.sqrt(a + delta)
```

---

### Test Case 2 – Cubic Root

```
a = 27
delta = 0.2
n = 20
```

Expected comparison:

```
Math.pow(a + delta, 1.0/3.0)
```

---

### Test Case 3 – Logarithm

```
delta = 0.1
n = 20
```

Expected comparison:

```
Math.log(1 + delta)
```

---

## 9. Complexity Analysis

Time Complexity:
[
O(n)
]

Space Complexity:
[
O(1)
]
