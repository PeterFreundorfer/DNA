package main;

public class NeedlemanWunsch{
	
	private DNASequence DNA;
	private double[][] matrix;

	public NeedlemanWunsch(DNASequence DNA){
		this.matrix = new double[DNA.getSeq1().length()+1][DNA.getSeq2().length()+1];
		this.DNA = DNA;
	}
	
	public DNASequence getDNA() {
		return DNA;
	}

	public void setDNA(DNASequence dNA) {
		DNA = dNA;
	}

	public double[][] getMatrix() {
		return matrix;
	}

	public double[][] assignValues(){
		this.matrix[0][0] = DNA.getGapPenalty();

		for(int i = 0; i<=DNA.getSeq1().length();i++)
			this.matrix[i][0] = DNA.getGapPenalty();
		
		for(int i = 0; i<=DNA.getSeq2().length();i++)
			this.matrix[0][i] = DNA.getGapPenalty();
		
		for (int i = 1; i <= DNA.getSeq1().length(); i++) {
            for (int j = 1; j <= DNA.getSeq2().length(); j++) {
                if (DNA.getSeq1().charAt(i - 1) == DNA.getSeq2().charAt(j - 1))
                    this.matrix[i][j] = matrix[i - 1][j - 1]+DNA.getMatchScore();
                else
                    this.matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i][j - 1]);
            }
		
		}
		return this.matrix;
	}
	
	public void printMatrix(double[][] matrix){
		
		for (int i = 0; i <= DNA.getSeq1().length(); i++){
			for (int j =0; j <= DNA.getSeq2().length(); j++){
				System.out.printf(matrix[i][j]+" ");
			}
			System.out.println();
		}
	
	}
}
	