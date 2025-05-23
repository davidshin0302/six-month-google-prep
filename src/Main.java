import leetCodeChallenges.arrays.CapturesforRook;
import leetCodeChallenges.arrays.FormableWordsFinder;
import leetCodeChallenges.arrays.GreatestCommonDivisor;
import leetCodeChallenges.arrays.KthMissingPositiveNumber;
import leetCodeChallenges.linkedList.ListNode;
import leetCodeChallenges.linkedList.MergeTwoSortedLists;
import leetCodeChallenges.linkedList.MiddleOfTheLinkedList;
import leetCodeChallenges.linkedList.RemoveDuplicatesSortedList;
import searchAlgorithm.BinarySearch;
import searchAlgorithm.BreadthFirstSearch;
import searchAlgorithm.DepthFirstSearch;
import sortAlgorithm.InsertionSort;
import sortAlgorithm.QuickSort;
import stackQueueAlgorithm.MyArrayStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(0, 5);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(0);

//        int[] arr = {5, 2, 4, 1, 6, 7};
//        int[] sortedArr = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
//
//        System.out.println("================");
//        System.out.println(BinarySearch.binarySearch(sortedArr, 23));
//
//        System.out.println("================");
//        QuickSort.quickSort(arr, 0, 5);
//        System.out.println(Arrays.toString(arr));
//
//        System.out.println("================");
//        breadthFirstSearch.printResult();
//
//        System.out.println("================");
//        depthFirstSearch.printOutput();
//
//        System.out.println("================");
//        int[] arr2 =  {2,3,4,7,11}; //k =5, output 9.
//        int[] arr3 = {1,2,3,4}; // k =2, output 6. Or alternatively test with [2], k=1, output 1.
//        System.out.println(KthMissingPositiveNumber.findMissingPositiveNumber(arr2, 5));
//
//        System.out.println("================");
//        int[] num = {7,7,2};
//        int output = GreatestCommonDivisor.findGCD(num);
//        System.out.println(output);

        //words = ["cat","bt","hat","tree"], chars = "atach"
//        String[] words = {"hello","world","leetcode"};
//        String character = "welldonehoneyr";
//
//        System.out.println(FormableWordsFinder.formableWordFinder(words,character));

//        char[][] board =
//                {{'.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '.', 'B', 'B', 'B', 'B', 'B', '.'}, {
//                        '.', 'p', 'B', 'p', 'p', 'p', 'B', 'p'}, {'.', 'p', 'B', 'p', 'R', 'p', 'B', 'p'}, {
//                        '.', 'p', 'B', 'p', 'p', 'p', 'B', 'p'}, {'.', '.', 'B', 'B', 'B', 'B', 'B', '.'}, {
//                        '.', '.', '.', 'p', 'p', 'p', '.', '.'}, {'.', '.', '.', '.', '.', '.', '.', '.'}};
//
//        System.out.println(CapturesforRook.numRookCaptures(board));

//        ListNode head1 = new ListNode(1);
//        head1.next = new ListNode(2);
//        head1.next.next = new ListNode(3);
//        head1.next.next.next = new ListNode(4);
//        head1.next.next.next.next = new ListNode(5);
//        head1.next.next.next.next.next = new ListNode(6);

//        System.out.println(RemoveDuplicatesSortedList.deleteDuplicates(head1));
//        System.out.println(MiddleOfTheLinkedList.middleNode(head1));

//        ListNode head1 = new ListNode(1);
//        head1.next = new ListNode(2);
//        head1.next.next = new ListNode(4);
//
//        ListNode head2 = new ListNode(3);
//        head2.next = new ListNode(4);
//        head2.next.next = new ListNode(4);
//        System.out.println(MergeTwoSortedLists.mergeList(head1, head2));

        MyArrayStack myArrayStack = new MyArrayStack<>(3);

        myArrayStack.push(1);
        myArrayStack.push(2);
        myArrayStack.push(3);
        myArrayStack.push(4);

        System.out.println("=========");
        System.out.println(myArrayStack.peek());
        System.out.println("=========");

        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.pop();
        myArrayStack.pop();

        System.out.println(myArrayStack.isEmpty());

        System.out.println(myArrayStack.size());
    }
}