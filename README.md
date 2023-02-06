# Weigthed-Activity-Selection
A program that implements a dynamic programming solution for the weighted activity selection problem in O(n lg n) time.

-	The absolute path of an input file will be provided as a command-line argument to the program. The jar will be run using the following command:<br>
java -jar activity_<19015550>.jar absolute_path_to_input_file<br>
The input file will have the number of activities n in the first line, followed by n lines. Each line will contain the start time, finish time and weight of one of the input activities. All data will be integers and will be separated by spaces, e.g., 

3<br>
1 2 1<br>
2 3 2<br>
3 4 5<br>
-	The program will output a file that has the maximum possible weight that can be obtained by choosing a mutually-compatible set of activities. The file will appear in the same directory as the input file. If the input file name is test1.in, then the output should be test1_<19015550>.out.
