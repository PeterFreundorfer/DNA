package main;

/**
 * 
 * @author Peter Freundorfer- 101001503
 *
 */

public class DNASequence {
	private String seq1;
	private String seq2;
	private double matchScore;
	private double gapPenalty;
	private double mismatchPenalty;
	
	public DNASequence(String seq1, String seq2, double matchScore, double gapPenalty, double mismatchPenalty) {
		super();
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.matchScore = matchScore;
		this.gapPenalty = gapPenalty;
		this.mismatchPenalty = mismatchPenalty;
	}

	public DNASequence(String seq1, String seq2) {
		this(seq1,seq2,1,0,0);
	}
	
	public DNASequence(String seq1, String seq2, int matchScore, int gapPenalty, int mismatchPenalty) {
		this.seq1 = seq1;
		this.seq2 = seq2;
		this.matchScore = matchScore;
		this.gapPenalty = gapPenalty;
		this.mismatchPenalty = mismatchPenalty;
	}
	
	public DNASequence(){
		this(null,null,0,0,0);
	}

	public String getSeq1() {
		return seq1;
	}

	public void setSeq1(String seq1) {
		this.seq1 = seq1;
	}

	public String getSeq2() {
		return seq2;
	}

	public void setSeq2(String seq2) {
		this.seq2 = seq2;
	}

	public double getMatchScore() {
		return matchScore;
	}

	public void setMatchScore(double matchScore) {
		this.matchScore = matchScore;
	}

	public double getGapPenalty() {
		return gapPenalty;
	}

	public void setGapPenalty(double gapPenalty) {
		this.gapPenalty = gapPenalty;
	}

	public double getMismatchPenalty() {
		return mismatchPenalty;
	}

	public void setMismatchPenalty(double mismatchPenalty) {
		this.mismatchPenalty = mismatchPenalty;
	}
	
	public boolean check(String seq){
		seq = seq.toUpperCase();
		for(int i = 0;i<seq.length();i++){
			if(seq.charAt(i)!='A'&&seq.charAt(i)!='C'&&seq.charAt(i)!='T'&&seq.charAt(i)!='G'){
				System.err.println("Error: Invalid character inputs for nucleotides. Give er another go.");
				return false;
			}
		}
		return true;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DNASequence other = (DNASequence) obj;
		if (Double.doubleToLongBits(gapPenalty) != Double.doubleToLongBits(other.gapPenalty))
			return false;
		if (Double.doubleToLongBits(matchScore) != Double.doubleToLongBits(other.matchScore))
			return false;
		if (Double.doubleToLongBits(mismatchPenalty) != Double.doubleToLongBits(other.mismatchPenalty))
			return false;
		if (seq1 == null) {
			if (other.seq1 != null)
				return false;
		} else if (!seq1.equals(other.seq1))
			return false;
		if (seq2 == null) {
			if (other.seq2 != null)
				return false;
		} else if (!seq2.equals(other.seq2))
			return false;
		return true;
	}

	public String toString() {
		return "DNASequence [seq1=" + seq1 + ", seq2=" + seq2 + ", matchScore=" + matchScore + ", gapPenalty="
				+ gapPenalty + ", mismatchPenalty=" + mismatchPenalty + "]";
	}

}
