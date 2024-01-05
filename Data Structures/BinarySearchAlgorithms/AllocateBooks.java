package BinarySearchAlgorithms;
// Assign books to all the k students soo that the difference of pages between them is minimum

public class AllocateBooks {

    public static boolean isValid(int [] books, int max, int size, int noOfStudents){
        int currentStudents = 1;
        int currentsSum = 0;
        for (int i = 0; i < size; i++) {
            currentsSum+=books[i];
            if(currentsSum>max){
                currentStudents++;
                currentsSum = books[i];
            }
            if(currentStudents>noOfStudents) return false;
        }
        return true;
    }

    public static int getMax(int [] books, int start, int end, int size, int numberOfStudents){
        int result = -1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(isValid(books,mid,size,numberOfStudents)){
                result = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return result;
    }

    public static void main(String[] args) {
        int [] books = {40,10,30,20};
        int numberOfStudents = 2;
        int sum = 0;
        int maxPagesBook = Integer.MIN_VALUE;
        int n = books.length;
        for (int book : books) {
            sum += book;
            maxPagesBook = Math.max(maxPagesBook, book);
        }
        System.out.println(getMax(books,maxPagesBook,sum,n,numberOfStudents));
    }
}
