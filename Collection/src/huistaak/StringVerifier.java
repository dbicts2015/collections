package huistaak;

@FunctionalInterface
public interface StringVerifier {

	/**
	 * 
	 * @param string
	 * @return
	 */
	public abstract boolean verify(String string);

}
