package genetic_algoritm;

public interface FitnessFunction {
	
	int getArity();
	long run(long[] genom);

}
