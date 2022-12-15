class FuncaoPolinomial extends Funcao implements Polinomio {
	private Map<String, ArrayList<double>> coeficientes;

	/**
	 * Cria a função polinomial multivariavel
	 *
	 * @param coeficientes mapa contendo o par variável:ArrayList de coeficientes
	 *						"x" : [0, 1, 2]  --> 2x^2 + 1x + 0
	 *						"y" : [1, 2]     --> 2y + 1
	 */
	public FuncaoPolinomial(Map<String, double> coeficientes) {
		this.coeficientes = coeficientes;
	}

	public Map<String, ArrayList<double>> getCoeficientes() {
		return this.coeficientes;
	}

	public int getGrau() {
		// iteramos sobre o map para ver o maior grau
		int maiorGrau = 0;
		for (ArrayList<double> coeficientesAtuais : this.coeficientes.values()) {
			if (coeficientesAtuais.size() > maiorGrau) {
				maiorGrau = coeficientesAtuais.size();
			}
		}
		return maiorGrau -1;
	}

	public double avaliaNoPonto(double x) {
		double resultado = 0;
		for (ArrayList<double> coeficientesAtuais : this.coeficientes.values()) {
			for (int i = 0; i < this.coeficientesAtuais.size(); i++) {
				resultado += this.coeficientesAtuais.get(i) * Math.pow(x, i);
			}
		}
		return resultado;
	}

	/**
	 * Retorna um novo polinomio correspondente à derivada parcial em relação à variável
	 *
	 * @param variavel por exemplo, "x"
	 *
	 * @return polinomio correspondente à derivada parcial em relação à variável
	 */
	public FuncaoPolinomial derivadaParcial(String variavel) {
		ArrayList<double> coeficientes = this.coeficientes.get(variavel);
		ArrayList<double> novosCoeficientes = new ArrayList<>();

		for (int i = 1; i < coeficientes.size(); i++) {
			novosCoeficientes.add(coeficientes.get(i) * i);
		}

		Map<String, ArrayList<double>> novosCoeficientesMap = new HashMap<>();
		novosCoeficientesMap.put(variavel, novosCoeficientes);

		return new FuncaoPolinomial(novosCoeficientesMap);
	}

	public Vetor<FuncaoPolinomial> gradiente() {

	}
}
