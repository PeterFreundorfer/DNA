package main;


public class Traceback {
	
	private NeedlemanWunsch NMW;
	private String[] results = new String[2];

	public Traceback(NeedlemanWunsch nMW) {
		super();
		NMW = nMW;
	}

	public NeedlemanWunsch getNMW() {
		return NMW;
	}

	public void setNMW(NeedlemanWunsch nMW) {
		NMW = nMW;
	}
	
	public void Trace(){
		StringBuilder a = new StringBuilder();
		StringBuilder b = new StringBuilder();
		
		if(this.NMW.getDNA().getGapPenalty()<this.NMW.getDNA().getMismatchPenalty()){	
			for(int i = this.NMW.getDNA().getSeq1().length(), j = this.NMW.getDNA().getSeq2().length(); i>0||j>0;){
				if(i>0 && j>0 && this.NMW.assignValues()[i-1][j]==this.NMW.assignValues()[i][j-1]){
					a.append(this.NMW.getDNA().getSeq1().charAt(--i));
					b.append(this.NMW.getDNA().getSeq2().charAt(--j));
				}	
				else if(j>0 && this.NMW.assignValues()[i][j-1]==this.NMW.assignValues()[i][j]){
					a.append(this.NMW.getDNA().getSeq2().charAt(--j));
					b.append("_");
				}
				else if(i>0 && this.NMW.assignValues()[i-1][j]==this.NMW.assignValues()[i][j]){
					a.append("_");
					b.append(this.NMW.getDNA().getSeq1().charAt(--i));
				}
			}
		}else{
			for(int i = this.NMW.getDNA().getSeq1().length(), j = this.NMW.getDNA().getSeq2().length(); i>0||j>0;){
				if(i>0 && j>0 && this.NMW.assignValues()[i-1][j]==this.NMW.assignValues()[i][j-1]){
					a.append(this.NMW.getDNA().getSeq1().charAt(--i));
					b.append(this.NMW.getDNA().getSeq2().charAt(--j));
				} else if(i>1 && j>2 && this.NMW.getDNA().getSeq2().charAt(j-3)==this.NMW.getDNA().getSeq1().charAt(i-2)
						&&this.NMW.getDNA().getSeq1().charAt(i-1)==this.NMW.getDNA().getSeq2().charAt(j-1)
						&&this.NMW.getDNA().getSeq1().charAt(i-1)==this.NMW.getDNA().getSeq2().charAt(j-2)){
					a.append(this.NMW.getDNA().getSeq1().charAt(--i));
					b.append(this.NMW.getDNA().getSeq2().charAt(--j));
				}
				else if(j>0 && this.NMW.assignValues()[i][j-1]==this.NMW.assignValues()[i][j]){
					a.append(this.NMW.getDNA().getSeq2().charAt(--j));
					b.append("_");
				}
				else if(i>0 && this.NMW.assignValues()[i-1][j]==this.NMW.assignValues()[i][j]){
					a.append("_");
					b.append(this.NMW.getDNA().getSeq1().charAt(--i));
				}
			}
		}
		
		this.results[0] = a.reverse().toString();
		this.results[1] = b.reverse().toString();
		
	}

	public void PrintResult(){
		System.out.println(results[0]);
		System.out.println(results[1]);
	}
	
	

}
