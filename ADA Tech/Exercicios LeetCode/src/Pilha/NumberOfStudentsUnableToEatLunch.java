package Pilha;
/*
 * The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. All students stand in a queue. Each student either prefers square or circular sandwiches.

The number of sandwiches in the cafeteria is equal to the number of students. The sandwiches are placed in a stack. At each step:

If the student at the front of the queue prefers the sandwich on the top of the stack, they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the i​​​​​​th sandwich in the stack (i = 0 is the top of the stack) and students[j] is the preference of the j​​​​​​th student in the initial queue (j = 0 is the front of the queue). Return the number of students that are unable to eat.

 

Example 1:

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0 
Explanation:
- Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
- Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
- Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
- Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
- Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
- Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
Hence all students are able to eat.
Example 2:

Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
 
 */
public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1,1,1,0};
        int[] sandwich = {1,0,1,0};

        System.out.println(countStudents(students, sandwich));
    }


    public static int countStudents(int[] students, int[] sandwiches) {
        int i = 0;
        int j = 0;
        int studentsLength = students.length;
        int sandwichesLength = sandwiches.length;
        int attempt = 0; // Counts the number of unsuccessful attempts

        while (attempt < studentsLength) {
            if (students[i] == sandwiches[j]) {
                // If the student takes the sandwich
                // Remove the student from the queue and advance to the next sandwich
                for (int k = i; k < studentsLength - 1; k++) {
                    students[k] = students[k + 1];
                }
                studentsLength--;  // Decrease the number of students

                // Remove the sandwich from the top of the stack
                for (int k = j; k < sandwichesLength - 1; k++) {
                    sandwiches[k] = sandwiches[k + 1];
                }
                sandwichesLength--;  // Decrease the number of sandwiches

                // Reset the attempt counter
                attempt = 0;
            } else {
                // Student goes to the end of the queue
                int currentStudent = students[i];

                // Move all elements to the left
                for (int k = i; k < studentsLength - 1; k++) {
                    students[k] = students[k + 1];
                }
                students[studentsLength - 1] = currentStudent;  // Place the student at the end

                // Increment the attempt counter
                attempt++;
            }

            // If all remaining students have tried and failed to take the current sandwich, break
            if (attempt == studentsLength) {
                break;
            }
        }

        return studentsLength;  // Return the number of students who couldn't eat
    }
}
