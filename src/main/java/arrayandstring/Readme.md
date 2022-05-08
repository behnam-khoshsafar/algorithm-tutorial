## 1-1 isUnique
###S1
- find out the encoding (ASCII or Unicode)
- use boolean array and index to show character
###S2
- User hashMap to store the character count.

## 1-2 Check Permutation
- Describe what it means for two strings to be permutations of each other. Now, look at that definition you provided. Can you check the strings against that definition?
- There is one solution that is 0(N log N) time. Another solution uses some space, but isO(N) time. 
- Could a hash table be useful?
- Two strings that are permutations should have the same characters, but in different orders. Can you make the orders the same?
###S1
- Sort the string and compare them
###S2
- Check character counts of the string and compare them
### 1-3 Urlify
- It's often easiest to modify strings by going from the end of the string to the beginning.
- You might find you need to know the number of spaces. Can you just count them?
### 1-4 Palindrome Permutation
- You do not have to-and should not-generate all permutations. This would be very inefficient.
- What characteristics would a string that is a permutation of a palindrome have?
- Have you tried a hash table? You should be able to get this down to 0(N) time.
- Can you reduce the space usage by using a bit vector?
- Palindrome -> is a word with same forward and backward
### 1-5 OneWay
- Start with the easy thing. Can you check each of the conditions separately?
- What is the relationship between the "insert character" option and the "remove char­ acter" option? Do these need to be two separate checks?
- Can you do all three checks in a single pass?
- We should check replacement and insertion and deletion separately.
### 1-6 String compression
- Do the easy thing first. Compress the string, then compare the lengths.
- Be careful that you aren't repeatedly concatenating strings together. This can be very inefficient.
### 1-7 Rotate Matrix
- Try thinking about it layer by layer. Can you rotate a specific layer?
- Rotating a specific layer would just mean swapping the values in four arrays. If you were asked to swap the values in two arrays, could you do this? Can you then extend it to four arrays?
### 1-8 Zero Matrix
- If you just cleared the rows and columns as you found Os, you'd likely wind up clearing the whole matrix. Try finding the cells with zeros first before making any changes to the matrix.
- If you've designed the algorithm as described thus far, you'll have an O(N log N) algorithminabalancedtree.ThisisbecausethereareNnodes,eachofwhichisatdepth O(log N) at worst. A node is touched once for each node above it. Therefore, the N nodes will be touched O( log N) time. There is an optimization that will give us an O(N) algorithm.
- You probably need some data storage to maintain a list of the rows and columns that need to be zeroed. Can you reduce the additional space usage to 0(1) by using the matrix itself for data storage?
### 1-9 String Rotation
- If a string is a rotation of another, then it's a rotation at a particular point. For example, a rotation of waterbottle at character 3 means cutting waterbottle at character 3 and putting the right half (erbottle) before the left half (wat).
- We are essentially asking if there's a way of splitting the first string into two parts, x and y,suchthatthefirststringisxyandthesecondstringisyx.Forexample,x = watand y = erbottle. The first string is xy = waterbottle. The second string is yx = erbottlewat.
- Think about the earlier hint. Then think about what happens when you concatenate erbottlewat to itself. You get erbottlewaterbottlewat.