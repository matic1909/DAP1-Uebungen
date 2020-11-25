package com.company;

public class Main {
    // Aufgabe 1
    public static int greatestProperDivisor( int n ) {
        int num = n;
        int divisor = 2;
        while(num > divisor) {
            if(num % divisor == 0) {
                num = num / divisor;
                return num;
            }
            divisor++;
        }
        return 1;
    }

    // Aufgabe 2
    public static int countPairs( int[] arr ) {
        int count = 0;
        int i = 0;
        while (i < arr.length - 1){
            if (arr[i] == arr[i + 1]) {
                count++;
                i++;
            }
            i++;
        }
        return count;
    }

    // Aufgabe 3
    public static boolean writtenBoth(int[] exam1, int[] exam2 ) {
        for(int studId1 : exam1) {
            for(int studId2 : exam2) {
                if(studId1 == studId2) return true;
            }
        }
        return false;
    }

    public static boolean notWrittenBoth(int[] exam1, int[] exam2 ) {
        return !writtenBoth(exam1, exam2);
    }

    public static int countWrittenBoth( int[] exam1, int[] exam2 ) {
        int count = 0;
        for(int studId1 : exam1) {
            for(int studId2 : exam2) {
                if(studId1 == studId2) count++;
            }
        }
        return count;
    }

    // Zusatzaugabe: Aufteigend sortierte Felder
    public static boolean sortedWrittenBoth( int[] exam1, int[] exam2 ) {
        // wenn die kleinste Matrikelnummer eines Stapels größer ist, als die größte des anderen, return false
        if(exam1[0] > exam2[exam2.length - 1] || exam2[0] > exam1[exam1.length - 1]) return false;

        int index1 = 0, index2 = 0;
        while( index1 < exam1.length && index2<exam2.length )
        {
            if ( exam1[index1] == exam2[index2] )
            {
                return true;
            } else {
                if (exam1[index1] < exam2[index2] )
                {
                    index1++;
                } else {
                    index2++;
                }
            }
        }
        return false;
    }

    // Aufgabe 4

    //Methoden aus der Vorlesung
    public static boolean[] initializeNumbers( int n )
    {
        boolean[] numbers = new boolean[n+1];
        for ( int i = 2; i < numbers.length; i++ )
        {
            numbers[i] = true;
        }
        return numbers;
    }

    public static void inspectNumbers( boolean[] numbers )
    {
        double limit = Math.sqrt( numbers.length );
        for ( int i = 2; i <= limit; i++ )
        {
            if ( numbers[i] )
            {
                discardMultiples( numbers, i );
            }
        }
    }

    public static void discardMultiples( boolean[] numbers, int i )
    {
        for ( int j = i*i; j < numbers.length; j+=i )
        {
            numbers[j] = false;
        }
    }

    public static int countPrimeNumbers( boolean[] numbers )
    {
        int count = 0;
        for ( boolean b : numbers )
        {
            if ( b ) {
                count++;
            }
        }
        return count;
    }

    public static int[] primeNumbersToArray( boolean[] numbers )
    {
        int[] primes = new int[countPrimeNumbers( numbers )];
        int nextPosition = 0;
        for (int i = 0; i < numbers.length; i++)
        {
            if ( numbers[i] )
            {
                primes[nextPosition] = i;
                nextPosition++;
            }
        }
        return primes;
    }

    public static void primeFactorization( int x ) {
        System.out.print(x + " = ");
        boolean[] numbers = initializeNumbers(x);
        inspectNumbers(numbers);
        int[] primeNumbers = primeNumbersToArray(numbers);

        int i = 0;
        while (x > 1) {
            if(x % primeNumbers[i] == 0) {
                System.out.print(primeNumbers[i]);
                x /= primeNumbers[i];

                if (x > 1){
                    System.out.print(" * ");
                } else {
                    System.out.println();
                }
            } else {
                i++;
            }
        }
    }

    // Aufgabe 5
    public static boolean isSquare( int[][] matrix ) {
        for (int[] ints : matrix) {
            if (ints.length != matrix.length) return false;
        }
        return true;
    }

    public static void scalMult( int[][] matrix, int k) {
        if(isSquare(matrix)) {
            for(int i = 0; i < matrix.length; i++) {
                for(int j = 0; j < matrix.length; i++) {
                    matrix[i][j] *= k;
                }
            }
        }
    }

    public int[] extractDiagonal( int[][] matrix ) {
        int[] diagonal = new int[matrix.length];
        if(isSquare(matrix)) {
            for(int i = 0; i < matrix.length; i++) {
                diagonal[i] = matrix[i][i];
            }
            return diagonal;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int testInt = 16;
        System.out.println("Greatest proper divisor of " + testInt + " is " + greatestProperDivisor(testInt));
        int[] testArray1 = {1,1,3,3,1,2,2,2,1};
        int[] testArray2 = {1,3,3,3,3,2,2,5,5};
        System.out.println("Number of pairs: " + countPairs(testArray1));
        System.out.println("Number of pairs: " + countPairs(testArray2));

        int size = 500;
        int offset = 500;
        int[] exam1 = new int [size];
        int [] exam2 = new int [size];

        for (int i = 0; i<size ;i++)
        {
            exam1[i] = i + offset;
            exam2[i] = i;
        }

        System.out.println( "Unsortiert:");
        System.out.println( "writtenBoth: " + writtenBoth(exam1,exam2) );
        System.out.println( "notWrittenBoth: " + notWrittenBoth(exam1,exam2) );
        System.out.println( "countWrittenBoth: " + countWrittenBoth(exam1,exam2));

        int primeTest1 = 204;
        int primeTest2 = 150;
        primeFactorization(primeTest1);
        primeFactorization(primeTest2);
    }
}
