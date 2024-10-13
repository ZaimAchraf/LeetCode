# Regular Expression Matching

## Problem Description

Given an input string `s` and a pattern `p`, implement regular expression matching with support for the following special characters:

- `.` Matches **any single character**.
- `*` Matches **zero or more** of the preceding element.

The matching should cover the **entire input string**, not just partial matches.

## Examples

### Example 1:
**Input:** 
s = "aa", p = "a"


**Output:** 
false

yaml
Copier le code

**Explanation:** 
Pattern `"a"` does not match the entire string `"aa"`.

---

### Example 2:
**Input:** 
s = "aa", p = "a*"


**Output:** 
true

yaml
Copier le code

**Explanation:** 
The `*` means zero or more of the preceding element (`'a'`). Therefore, by repeating `'a'` once, the pattern matches the string `"aa"`.

---

### Example 3:
**Input:** 
s = "ab", p = ".*"


**Output:** 
true

markdown
Copier le code

**Explanation:** 
The `.` means any single character, and `*` allows it to repeat zero or more times. Hence, `"ab"` is matched.

## Constraints

- `1 <= s.length <= 20`
- `1 <= p.length <= 20`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `.` and `*`.
- It is guaranteed that for each occurrence of the character `*`, there will be a previous valid character to match.

## Usage

You can use this implementation for string matching with the specified regular expression rules. It covers a variety of cases where partial or complete pattern matching is required.

---

Happy coding!
