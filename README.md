# Software Testing and Quality Assurance - 2023
## Black Box Testing and Graph Coverage

**Deadline & Submission:**
1. **Teams:** Form a team of 2-3.

### Question 1: Black Box Testing
JFreeChart is an open-source Java framework for chart calculation, creation, and display. This framework supports many different graphical chart types, including pie charts, bar charts, line charts, histograms, and several other chart types. We used this framework before in lab 2.

**You will be provided with:**
- An Eclipse Java project for JFreeChart. The project includes:
  a. A jar file for a modified version of JFreeChart for this assignment (`JFreeChart.jar` within the `JFreeChartJar` folder).
  b. A set of needed libraries for the JFreeChart jar file to compile properly.
  c. A sample test file `QuarterClassTest.java` provides a sample test case. This test case passes.
  d. A modified JavaDocs zip file including the JavaDocs for the JFreeChart application.

**Classes to be tested:**
- `org.jfree.data.time.Quarter` (test all constructors and methods)

**Deliverables:**
- Submit ONE test file including your tests for the `Quarter` class.
- Bugs Report: Contains the method to be tested, test cases, status (Passed, Failed), and any additional notes if you have.

### Question 2: Graph Coverage
Consider the following method:

**Deliverables:**
- Text file containing all nodes (comma-separated) mentioning the start and end nodes, test paths for nodes coverage with a test case for each path.
- Text file containing all edges (comma-separated), test paths for edges coverage with a test case for each path.
- Text file containing Prime path coverage with a test case for each path.
- Screenshot for the graph
```java
public int findTheFirstPrimeNumber(int startNumber, int endNumber) {
    if (startNumber > endNumber)
        return -1;
    if (startNumber < 2)
        return -1;
    for (int i = startNumber; i <= endNumber; i++) {
        if (i % 2 == 0)
            continue;
        boolean isPrime = true;
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            return i;
    }
    return -1;
}

