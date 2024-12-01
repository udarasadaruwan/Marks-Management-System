import java.util.Scanner;

public class MarkManagementSystem {


    static String s_Id[] = new String[100];
    static String sName[] = new String[100];
    static int dbmsMarks[] = new int[100];
    static int pfMarks[] = new int[100];
    static int incrimenter = 0;

    //---------------------------------------------------------------------------------------------------------------
    //find rank
    static int rank(int stIndex) {
        int[] totalMarks = new int[incrimenter];

        for (int i = 0; i < incrimenter; i++) {
            if (dbmsMarks[i] != -1 && pfMarks[i] != -1) {
                totalMarks[i] = dbmsMarks[i] + pfMarks[i];
            } else {
                totalMarks[i] = -1;
            }
        }

        int rank = 1;
        int currentMarks = totalMarks[stIndex];
        for (int mark : totalMarks) {
            if (mark > currentMarks) {
                rank++;
            }
        }
        return rank;
    }
    //---------------------------------------------------------------------------------------------------------------

    //Home page
    static int homePage() {
        Scanner input = new Scanner(System.in);

        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tWELCOME TO \t MARKS MANAGEMENT SYSTEM\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("[1] Add New Student\t\t\t\t[2] Add New Student With Marks");
        System.out.println("[3] Add Marks\t\t\t\t\t[4] Update Student Details");
        System.out.println("[5] Update Marks\t\t\t\t[6] Delete Student");
        System.out.println("[7] Print Student Details\t\t\t[8] Print Student Ranks");
        System.out.println("[9] Best in Programming Fundamentals\t\t[10] Best in Data Base Management System");
        System.out.println(" ");
        System.out.println("Enter an Option to continue > ");
        int userInput = input.nextInt();
        return userInput;

    }

    //01) add new student
    static void addNewStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD NEW STUDENT\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            if (s_Id.length == incrimenter) {
                System.out.println("");
                System.out.println("Database is full...");
                return;
            }
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;

            // Check if the ID already exists
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    exists = true;
                    System.out.println("Student ID already exists!");

                }
            }

            if (!exists) {
                // Add the new student
                s_Id[incrimenter] = studentID;
                System.out.print("Enter Student Name: ");
                sName[incrimenter] = input.next();
                dbmsMarks[incrimenter] = -1;
                pfMarks[incrimenter] = -1;
                incrimenter++;
                System.out.print("Student has been added successfully!. ");
                System.out.print("Do you want to add a new student? (Y/N) : ");
                String userInput = input.next();

                if (!userInput.equalsIgnoreCase("y")) {
                    // Exit the loop and method if the user says "N"
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                }
            }

        }
    }

    //02) Add new student with marks
    static void addNewStudentWithMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tADD  NEW STUDENT WITH MARKS\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            if (s_Id.length == incrimenter) {
                System.out.println("");
                System.out.println("Database is full...");
                return;
            }
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;

            // Check if the ID already exists
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    exists = true;
                    System.out.println("Student ID already exists!");

                }
            }

            if (!exists) {
                // Add the new student
                s_Id[incrimenter] = studentID;
                System.out.print("Enter Student Name: ");
                sName[incrimenter] = input.next();

                System.out.print("Programming fundamentals Marks : ");
                int pfMark = input.nextInt();
                if (pfMark < 0 || pfMark > 100) {
                    while (true) {
                        System.out.println("invalid Marks, please Enter correct Marks.");
                        System.out.print("Programming fundamentals Marks : ");
                        pfMark = input.nextInt();
                        if (pfMark >= 0 && pfMark <= 100) {
                            pfMarks[incrimenter] = pfMark;
                            break;
                        }
                    }
                } else {
                    pfMarks[incrimenter] = pfMark;
                }

                System.out.print("Database Management System Marks : ");
                int dbMark = input.nextInt();
                if (dbMark < 0 || dbMark > 100) {
                    while (true) {
                        System.out.println("invalid Marks, please Enter correct Marks.");
                        System.out.print("Database Management System Marks : ");
                        dbMark = input.nextInt();
                        if (dbMark >= 0 && dbMark <= 100) {
                            pfMarks[incrimenter] = dbMark;
                            break;
                        }
                    }
                } else {
                    dbmsMarks[incrimenter] = dbMark;
                }

                incrimenter++;
                System.out.print("Student has been added successfully!. ");
                System.out.print("Do you want to add a new student? (Y/N) : ");
                String userInput = input.next();

                if (!userInput.equalsIgnoreCase("y")) {
                    // Exit the loop and method if user says "N"
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                }
            }

        }
    }

    //03) add marks
    static void addMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tADD MARKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    System.out.println("Student Name: " + sName[i]);
                    if (dbmsMarks[i] != -1 || pfMarks[i] != -1) {
                        System.out.println("This student's marks already added.");
                        System.out.println("If you want to update marks, please use [4] Update Marks Option.");
                        System.out.println(" ");
                        exists = true;
                        break;
                    }
                    exists = true;
                    System.out.print("Programming fundamentals Marks : ");
                    int pfMark = input.nextInt();
                    if (pfMark < 0 || pfMark > 100) {
                        while (true) {
                            System.out.println("invalid Marks, please Enter correct Marks.");
                            System.out.print("Programming fundamentals Marks : ");
                            pfMark = input.nextInt();
                            if (pfMark >= 0 && pfMark <= 100) {
                                pfMarks[i] = pfMark;
                                break;
                            }
                        }
                    } else {
                        pfMarks[i] = pfMark;
                    }

                    System.out.print("Database Management System Marks : ");
                    int dbMark = input.nextInt();
                    if (dbMark < 0 || dbMark > 100) {
                        while (true) {
                            System.out.println("invalid Marks, please Enter correct Marks.");
                            System.out.print("Database Management System Marks : ");
                            dbMark = input.nextInt();
                            if (dbMark >= 0 && dbMark <= 100) {
                                dbmsMarks[i] = dbMark;
                                break;
                            }
                        }
                    } else {
                        dbmsMarks[i] = dbMark;
                    }
                    System.out.print("Marks has been added successfully!. ");
                    System.out.print("Do you want to add a marks for another student? (Y/N) : ");
                    String userInput = input.next();

                    if (!userInput.equalsIgnoreCase("y")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        // Exit the loop and method if user says "N"
                        return;
                    }
                }
            }
            if (!exists) {
                System.out.print("Invalid Student ID. Please try again.");
            }

            System.out.print("Do you want to add marks for another student? (Y/N): ");
            String userInput = input.next();
            if (!userInput.equalsIgnoreCase("y")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            }

        }

    }

    //04) Update student deatails
    static void updateStudentDeatails() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tUPDATE STUDENT DEATAILS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");

        while (true) {
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    System.out.println("Student Name: " + sName[i]);
                    exists = true;
                    System.out.print("Enter the new student name : ");
                    String newStudentName = input.next();
                    sName[i] = newStudentName;

                    System.out.println("");
                    System.out.print("Student details has been updated successfully!. ");
                    System.out.print("Do you want to update another student details? (Y/N) : ");
                    String userInput = input.next();

                    if (!userInput.equalsIgnoreCase("y")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        // Exit the loop and method if user says "N"
                        return;
                    }
                }
            }
            if (!exists) {
                System.out.println("Invalid Student ID. Please try again.");
                System.out.print("Do you want to search another student? (Y/N): ");
                String userInput = input.next();
                if (!userInput.equalsIgnoreCase("y")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                }
            }


        }


    }

    //05) Update Marks
    static void updateMarks() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tUPDATE MARKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    System.out.println("Student Name: " + sName[i]);
                    if (dbmsMarks[i] == -1 || pfMarks[i] == -1) {
                        System.out.println("This student's marks yet to be added.");
                        System.out.println("Do you want to update the marks of another student? (Y/n) :");
                        String userInput = input.next();
                        if (!userInput.equalsIgnoreCase("y")) {
                            exists = true;
                            System.out.print("\033[H\033[2J");
                            System.out.flush();
                            // Exit the loop and method if user says "N"
                            break;
                        }
                    }
                    exists = true;
                    System.out.print("Enter new Programming fundamentals Marks : ");
                    int pfMark = input.nextInt();
                    if (pfMark < 0 || pfMark > 100) {
                        while (true) {
                            System.out.println("invalid Marks, please Enter correct Marks.");
                            System.out.print("Enter new Programming fundamentals Marks : ");
                            pfMark = input.nextInt();
                            if (pfMark >= 0 && pfMark <= 100) {
                                pfMarks[i] = pfMark;
                                break;
                            }
                        }
                    } else {
                        pfMarks[i] = pfMark;
                    }

                    System.out.print("Enter new Database Management System Marks : ");
                    int dbMark = input.nextInt();
                    if (dbMark < 0 || dbMark > 100) {
                        while (true) {
                            System.out.println("invalid Marks, please Enter correct Marks.");
                            System.out.print("Enter new Database Management System Marks : ");
                            dbMark = input.nextInt();
                            if (dbMark >= 0 && dbMark <= 100) {
                                dbmsMarks[i] = dbMark;
                                break;
                            }
                        }
                    } else {
                        pfMarks[i] = dbMark;
                    }
                    System.out.println("Marks have been updated successfully!. ");
                    System.out.print("Do you want to update marks for another student? (Y/N) : ");
                    String userInput = input.next();

                    if (!userInput.equalsIgnoreCase("y")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        // Exit the loop and method if user says "N"
                        return;
                    }
                }
            }
            if (!exists) {
                System.out.println("Invalid Student ID. Please try again.");

                System.out.println("Do you want to search for another student? (Y/N): ");
                String userInput = input.next();
                if (!userInput.equalsIgnoreCase("y")) {
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                }
            }


        }
    }

    //06) Delete Student
    static void deleteStudent() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\t\tDelete STUDENT\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        if (incrimenter == 0) {
            System.out.println("");
            System.out.println("No students in the system to delete.");
            return;
        }
        while (true) {
            if (incrimenter == 0) {
                System.out.println("");
                System.out.println("No students in the system to delete.");
                return;
            }
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;

            // Check if the ID already exists
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    exists = true;
                    for (int j = i; j < incrimenter - 1; j++) {
                        s_Id[j] = s_Id[j + 1];
                        sName[j] = sName[j + 1];
                        dbmsMarks[j] = dbmsMarks[j + 1];
                        pfMarks[j] = pfMarks[j + 1];
                    }
                    incrimenter--;

                    s_Id[incrimenter] = null;
                    sName[incrimenter] = null;
                    dbmsMarks[incrimenter] = -1;
                    pfMarks[incrimenter] = -1;
                    System.out.println("");
                    System.out.println("Student Deleted successfully!");
                    System.out.print("Do you want to delete another student? (Y/N) : ");
                    String userInput = input.next();
                    if (!userInput.equalsIgnoreCase("y")) {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        return;
                    }
                }
            }

            if (!exists) {
                System.out.print("Invalid student ID ");
                System.out.print("Do you want to search another student? (Y/N) : ");
                String userInput = input.next();

                if (!userInput.equalsIgnoreCase("y")) {
                    // Exit the loop and method if the user says "N"
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    break;
                }
            }

        }
    }

    //07) Print Student
    static void printStudentDeatails() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPRINT STUDENT DETAILS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            System.out.print("Enter Student ID: ");
            String studentID = input.next();
            boolean exists = false;
            for (int i = 0; i < incrimenter; i++) {
                if (studentID.equalsIgnoreCase(s_Id[i])) {
                    System.out.println("Student Name: " + sName[i]);
                    if (dbmsMarks[i] == -1 || pfMarks[i] == -1) {
                        System.out.println("Marks yet to be added");
                        System.out.println(" ");
                        exists = true;
                        break;
                    } else {
                        int rank = rank(i);
                        String rankText;
                        if (rank == 1) {
                            rankText = "(First)";
                        } else if (rank == 2) {
                            rankText = "(Second)";
                        } else if (rank == 3) {
                            rankText = "(Third)";
                        } else if (rank == incrimenter) {
                            rankText = "(Last)";
                        } else {
                            rankText = " ";
                        }

                        System.out.println("+---------------------------------------+-----------------+");
                        System.out.printf("| %-37s | %15d |\n", "Programming Fundamentals Marks", pfMarks[i]);
                        System.out.printf("| %-37s | %15d |\n", "Database Management System Marks", dbmsMarks[i]);
                        System.out.printf("| %-37s | %15d |\n", "Total Marks", (pfMarks[i] + dbmsMarks[i]));
                        System.out.printf("| %-37s | %15.2f |\n", "Avg. Marks", (pfMarks[i] + dbmsMarks[i]) / 2.0);
                        System.out.printf("| %-37s | %15s |\n", "Rank", rank + " " + rankText);
                        System.out.println("+---------------------------------------+-----------------+");
                        System.out.println("");
                        exists = true;
                    }

                }
            }

            if (!exists) {
                System.out.print("Invalid Student ID. Please try again.");
            }

            System.out.print("Do you want to search another student details? (Y/N) : ");
            String userInput = input.next();
            if (!userInput.equalsIgnoreCase("y")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            }

        }
    }

    //08 Print Student Ranks
    static void priintStudentRanks() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\t\tPRINT STUDENTS' RANKS\t\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");
        while (true) {
            // Check if there are students with marks added
            int validStudents = 0;
            for (int i = 0; i < incrimenter; i++) {
                if (pfMarks[i] != -1 && dbmsMarks[i] != -1) {
                    validStudents++;
                }
            }

            if (validStudents == 0) {
                System.out.println("No students with marks added yet.");
                return;
            }

            // Create a temporary array to store student details
            String[] tempIds = new String[validStudents];
            String[] tempNames = new String[validStudents];
            int[] tempTotalMarks = new int[validStudents];
            double[] tempAvgMarks = new double[validStudents];

            // Copy valid students into the temporary arrays
            int index = 0;
            for (int i = 0; i < incrimenter; i++) {
                if (pfMarks[i] != -1 && dbmsMarks[i] != -1) {
                    tempIds[index] = s_Id[i];
                    tempNames[index] = sName[i];
                    tempTotalMarks[index] = pfMarks[i] + dbmsMarks[i];
                    tempAvgMarks[index] = tempTotalMarks[index] / 2.0;
                    index++;
                }
            }

            // Sort the temporary arrays based on total marks
            for (int i = 0; i < validStudents - 1; i++) {
                for (int j = i + 1; j < validStudents; j++) {
                    if (tempTotalMarks[i] < tempTotalMarks[j]) {
                        // Swap total marks
                        int temp = tempTotalMarks[i];
                        tempTotalMarks[i] = tempTotalMarks[j];
                        tempTotalMarks[j] = temp;

                        // Swap average marks
                        double tempAvg = tempAvgMarks[i];
                        tempAvgMarks[i] = tempAvgMarks[j];
                        tempAvgMarks[j] = tempAvg;

                        // Swap IDs
                        String tempId = tempIds[i];
                        tempIds[i] = tempIds[j];
                        tempIds[j] = tempId;

                        // Swap Names
                        String tempName = tempNames[i];
                        tempNames[i] = tempNames[j];
                        tempNames[j] = tempName;
                    }
                }
            }

            // Print the sorted student ranks
            System.out.println("+------+----------+----------------------+-------------+------------+");
            System.out.println("| Rank | ID       | Student Name         | Total Marks | Avg. Marks |");
            System.out.println("+------+----------+----------------------+-------------+------------+");

            for (int i = 0; i < validStudents; i++) {
                System.out.printf("| %-4d | %-8s | %-20s | %-11d | %-10f |\n",
                        i + 1, tempIds[i], tempNames[i], tempTotalMarks[i], tempAvgMarks[i]);
            }

            System.out.println("+------+----------+----------------------+-------------+------------+");


            System.out.print("Do you want to go back to main menu? (Y/N) : ");
            String userInput = input.next();
            if (!userInput.equalsIgnoreCase("n")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
                break;
            }

        }
    }

    //09) Best in programming fundamentals
    static void bestInPf() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tBEST IN PROGRAMMING FUNDAMENTALS\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");

        if (incrimenter == 0) {
            System.out.println("No students in the system.");
            return;
        }

        // Count valid students (those with marks added)
        int validCount = 0;
        for (int i = 0; i < incrimenter; i++) {
            if (pfMarks[i] != -1) {
                validCount++;
            }
        }

        if (validCount == 0) {
            System.out.println("No Programming Fundamentals marks have been added yet.");
            return;
        }

        // Temporary arrays for valid students only
        int[] validPFMarks = new int[validCount];
        int[] validDBMSMarks = new int[validCount];
        String[] validIds = new String[validCount];
        String[] validNames = new String[validCount];

        // Populate temporary arrays
        int index = 0;
        for (int i = 0; i < incrimenter; i++) {
            if (pfMarks[i] != -1) {
                validPFMarks[index] = pfMarks[i];
                validDBMSMarks[index] = dbmsMarks[i];
                validIds[index] = s_Id[i];
                validNames[index] = sName[i];
                index++;
            }
        }

        // Sort the valid students by PF marks in descending order
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - 1 - i; j++) {
                if (validPFMarks[j] < validPFMarks[j + 1]) {
                    // Swap PF marks
                    int tempPf = validPFMarks[j];
                    validPFMarks[j] = validPFMarks[j + 1];
                    validPFMarks[j + 1] = tempPf;

                    // Swap corresponding DBMS marks
                    int tempDbms = validDBMSMarks[j];
                    validDBMSMarks[j] = validDBMSMarks[j + 1];
                    validDBMSMarks[j + 1] = tempDbms;

                    // Swap corresponding student IDs
                    String tempId = validIds[j];
                    validIds[j] = validIds[j + 1];
                    validIds[j + 1] = tempId;

                    // Swap corresponding student names
                    String tempName = validNames[j];
                    validNames[j] = validNames[j + 1];
                    validNames[j + 1] = tempName;
                }
            }
        }

        // Display the sorted list
        System.out.println("+----------+----------------------+------------+------------+");
        System.out.println("| ID       | Student Name         | PF Marks   | DBMS Marks |");
        System.out.println("+----------+----------------------+------------+------------+");

        for (int i = 0; i < validCount; i++) {
            System.out.printf("| %-8s | %-20s | %-10d | %-10d |\n", validIds[i], validNames[i], validPFMarks[i], validDBMSMarks[i]);
        }

        System.out.println("+----------+----------------------+------------+------------+");

        // Ask user whether to go back to the main menu
        System.out.print("Do you want to go back to main menu? (Y/N) : ");
        String userInput = input.next();
        if (!userInput.equalsIgnoreCase("n")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }


    //10) Best in Database management system
    static void bestInDBMS() {
        Scanner input = new Scanner(System.in);
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println("|\t\t\tBEST IN DATABASE MANAGEMENT SYSTEM\t\t\t\t|");
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(" ");

        if (incrimenter == 0) {
            System.out.println("No students in the system.");
            return;
        }

        // Count valid students (those with marks added)
        int validCount = 0;
        for (int i = 0; i < incrimenter; i++) {
            if (dbmsMarks[i] != -1) {
                validCount++;
            }
        }

        if (validCount == 0) {
            System.out.println("No DBMS marks have been added yet.");
            return;
        }

        // Temporary arrays for valid students only
        int[] validDBMSMarks = new int[validCount];
        int[] validPFMarks = new int[validCount];
        String[] validIds = new String[validCount];
        String[] validNames = new String[validCount];

        // Populate temporary arrays
        int index = 0;
        for (int i = 0; i < incrimenter; i++) {
            if (dbmsMarks[i] != -1) {
                validDBMSMarks[index] = dbmsMarks[i];
                validPFMarks[index] = pfMarks[i];
                validIds[index] = s_Id[i];
                validNames[index] = sName[i];
                index++;
            }
        }

        // Sort the valid students by DBMS marks in descending order
        for (int i = 0; i < validCount - 1; i++) {
            for (int j = 0; j < validCount - 1 - i; j++) {
                if (validDBMSMarks[j] < validDBMSMarks[j + 1]) {
                    // Swap DBMS marks
                    int tempDbms = validDBMSMarks[j];
                    validDBMSMarks[j] = validDBMSMarks[j + 1];
                    validDBMSMarks[j + 1] = tempDbms;

                    // Swap corresponding PF marks
                    int tempPf = validPFMarks[j];
                    validPFMarks[j] = validPFMarks[j + 1];
                    validPFMarks[j + 1] = tempPf;

                    // Swap corresponding student IDs
                    String tempId = validIds[j];
                    validIds[j] = validIds[j + 1];
                    validIds[j + 1] = tempId;

                    // Swap corresponding student names
                    String tempName = validNames[j];
                    validNames[j] = validNames[j + 1];
                    validNames[j + 1] = tempName;
                }
            }
        }

        // Display the sorted list
        System.out.println("+----------+----------------------+------------+------------+");
        System.out.println("| ID       | Student Name         | DBMS Marks | PF Marks   |");
        System.out.println("+----------+----------------------+------------+------------+");

        for (int i = 0; i < validCount; i++) {
            System.out.printf("| %-8s | %-20s | %-10d | %-10d |\n", validIds[i], validNames[i], validDBMSMarks[i], validPFMarks[i]);
        }

        System.out.println("+----------+----------------------+------------+------------+");

        // Ask user whether to go back to the main menu
        System.out.print("Do you want to go back to main menu? (Y/N) : ");
        String userInput = input.next();
        if (!userInput.equalsIgnoreCase("y")) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }



    public static void main(String[] args) {
        while (true) {
            int userSelection = homePage();
            switch (userSelection) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addNewStudentWithMarks();
                    break;
                case 3:
                    addMarks();
                    break;
                case 4:
                    updateStudentDeatails();
                    break;
                case 5:
                    updateMarks();
                    break;
                case 6:
                    deleteStudent();
                    break;
                case 7:
                    printStudentDeatails();
                    break;
                case 8:
                    priintStudentRanks();
                    break;
                case 9:
                    bestInPf();
                    break;
                case 10:
                    bestInDBMS();
                    break;
                default:
                    System.out.println("\ninvalid selection number please enter the correct value....");
            }
        }


    }
}
