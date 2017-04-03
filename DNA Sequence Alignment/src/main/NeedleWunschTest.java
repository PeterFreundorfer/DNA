package main;

import java.util.Scanner;

public class NeedleWunschTest {
		
		public static void main(String arg[]){
			DNASequence dna = new DNASequence();
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Input first DNA sequence:");
			
			boolean valid = false;
			
			while(!valid){
				dna.setSeq1(s.next());
				valid = dna.check(dna.getSeq1());
			}
			valid = false;
			System.out.println("Input second DNA sequence:");
			
			while(!valid){
				dna.setSeq2(s.next());
				valid = dna.check(dna.getSeq2());
			}
			
			DNASequence DNA = new DNASequence(dna.getSeq1(), dna.getSeq2());
			NeedlemanWunsch matrix = new NeedlemanWunsch(DNA);
			
			System.out.println("1.Re-Enter DNA Sequence 1.");
			System.out.println("2.Re-Enter DNA Sequence 2.");
			System.out.println("3.Re-Enter MatchScore.");
			System.out.println("4.Re-Enter Mismatch Penalty.");
			System.out.println("5.Re-Enter Gap Penalty.");
			System.out.println("6.Re-Enter Print Matrix.");
			System.out.println("7.Re-Enter Print Optimal Alignment of the 2 DNA Sequences.");
			System.out.println("8.Re-Enter DNA Sequence 1.");
			System.out.println("9.Re-Enter DNA Sequence 1.");
			System.out.println("0.Exit");
			
			int path = s.nextInt();
			
			while(path!=0){
				switch(path){
					case(1):
						valid = false;
					System.out.println("Input second DNA sequence:");
					
					while(!valid){
						dna.setSeq1(s.next());
						valid = dna.check(dna.getSeq1());
					}
					case(2):
						valid = false;
						System.out.println("Input second DNA sequence:");
					
						while(!valid){
							dna.setSeq2(s.next());
							valid = dna.check(dna.getSeq2());
						}
					case(3):
						
					case(4):
					
					case(5):
					
					case(6):
					
					case(7):
					
					case(8):
					
					case(9):
					
					case(0):
				}
				path = s.nextInt();
			}
			
			
			matrix.printMatrix(matrix.assignValues());
			
			Traceback trace = new Traceback(matrix);
			trace.Trace();
			trace.PrintResult();
		
		}
}
