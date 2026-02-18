# BMI Comparison Program

Four users will input three quantities (name, height (inches), weight (pounds). Subsequently, the program will then rank each value in increasing order (lowest - highest).

## Classes
  
### BMIComparison (main)

#### Responsibilities
- Read input for four people: name, height (inches), weight (pounds).
- Compute BMI for each person using bmi = 703.0 * weight / (height * height).
- Rank and report results for height, weight, and BMI separately (from lowest to highest, but implemented by repeatedly finding the maximum).

#### Fields (local variables in main)
- String name1, name2, name3, name4
- double height1, height2, height3, height4
- double weight1, weight2, weight3, weight4
- double bmi1, bmi2, bmi3, bmi4

#### Methods

##### Static

1. public static void main(String[] args)
   - Create a Scanner for input.
   - For each person 1–4: prompt and read name (String), height (double), weight (double).
   - Compute each bmiX using the given BMI formula.
   - Print a separator and the header "Ranking by Height", then call find1st with the four heights and names, and starting rank 1.
   - Print a separator and the header "Ranking by Weight", then call find1st with the four weights and names, and starting rank 1.
   - Print a separator and the header "Ranking by BMI", then call find1st with the four BMIs and names, and starting rank 1.

2. public static void find1st(
      double candidate_value1, double candidate_value2,
      double candidate_value3, double candidate_value4,
      String candidate_name1, String candidate_name2,
      String candidate_name3, String candidate_name4,
   )
   - Compute max of the four values using three Math.max calls.
   - Use if/else to determine which candidate holds max.
   - Call report(currentRank, winnerName, max).
   - Call find2nd on the remaining three candidates (their values and names) with currentRank + 1.

3. public static void find2nd(
      double candidate_value1, double candidate_value2,
      double candidate_value3,
      String candidate_name1, String candidate_name2,
      String candidate_name3,
   )
   - Compute max of the three values using two Math.max calls.
   - Use if/else to determine which candidate holds max.
   - Call report(currentRank, winnerName, max).
   - Call findLastTwo on the remaining two candidates (their values and names) with currentRank + 1.

4. public static void findLastTwo(
      double value1, double value2,
      String name1, String name2,
   )
   - If value1 >= value2, then:
     - Call report(currentRank, name1, value1) (this is the next highest).
     - Call report(3, name2, value2) (this is the lowest).
   - Else:
     - Call report(currentRank, name2, value2).
     - Call report(4, name1, value1).

5. public static void report(int rank, String name, double value)
   - System.out.printf("Rank %d is %s, with a value of %.2f%n", rank, name, value);

##### Instance
- No instance fields or methods are required; all behavior can be implemented with static methods since there is no persistent object state needed between calls.
