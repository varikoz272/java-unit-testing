# java-unit-testing
Requires:
  - jdk-21
  - JUnit-5

Includes:
  - Multiple solved Leet Code problems
  - Testing interface Testable.java

For solving problems, implement algorithm.Testable. After creating your class paste test from LeetCode into leetCodeTest() and your own into test(), add it into testAllAlgorithms() by creating an instance of solving class. Manage tests with this method.

No license, use for whatever

```mermaid
classDiagram
class RemoveDuplicateLetters  {
    +String removeDuplicateLetters(String s)
    -void swap(String array, int f, int s)
    -void quickSort(String array, int from, int until)
}

class AlgorithmController {
    +void testAlgorithm(Testable algorithmInstance)
    +void testAllAlgorithms()
}

class IntToRoman {
    +String intToRoman(int num)
}

class JumpGame2 {
    -JumpPair[] checkedCache
    +int jump(int[] array)
    -int amountOfJumpsToFinish(int[] array, int startIndex, int curAmountOfJumps)
    -int[] getSlice(int[] fullArray, int from, int length)
    -void swap(int[] array, int f, int s)
    -void quickSort(int[] array, int from, int until)
}

JumpGame2 ..o JumpPair

class JumpPair {
    +int start
    +int amountOfJumps
}

class LongestPolindromicSubstring {
    -IntStringPair[] cache
    -isAlreadyChecked(int l, int r, IntStringPair[] cache)
    -String addRecordAndGet(String str, int l, int r, IntStringPair[] cache)
    -String longestPalindrome(String str, int l, int r)
    +String longestPalindrome(String s)
    -boolean isPolindrom(String str)
}

LongestPolindromicSubstring ..o IntStringPair

class IntStringPair {
    -int r
    -String longestStr
}

class PolindromeNumber {
    +boolean isPalindrome(int x)
}

class Pow {
    +double pow(double x, int n)
}

class Testable {
    <<interface>>
	+void leetCodeTest()
	+void test()
	+void fullTest()
}

Testable <|.. Pow
Testable <|.. RemoveDuplicateLetters
Testable <|.. IntToRoman
Testable <|.. JumpGame2
Testable <|.. PolindromeNumber
Testable <|.. LongestPolindromicSubstring
AlgorithmController --* Testable
```
