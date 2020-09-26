package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestCupomFiscal {

	private String BRK = System.lineSeparator();
	
	private String TEXTO_ESPERADO_LOJA_COMPLETA = "Loja 1" + BRK +
			"Log 1, 10 C1" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"CEP:11111-111 Tel (11) 1111-1111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_NUMERO = "Loja 1" + BRK +
			"Log 1, s/n C1" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"CEP:11111-111 Tel (11) 1111-1111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_COMPLEMENTO = "Loja 1" + BRK +
			"Log 1, 10" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"CEP:11111-111 Tel (11) 1111-1111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_BAIRRO = "Loja 1" + BRK +
			"Log 1, 10 C1" + BRK +
			"Mun 1 - E1" + BRK +
			"CEP:11111-111 Tel (11) 1111-1111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_CEP = "Loja 1" + BRK +
			"Log 1, 10 C1" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"Tel (11) 1111-1111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_TELEFONE = "Loja 1" + BRK +
			"Log 1, 10 C1" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"CEP:11111-111" + BRK +
			"Obs 1" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	private String TEXTO_ESPERADO_SEM_OBSERVACAO = "Loja 1" + BRK +
			"Log 1, 10 C1" + BRK +
			"Bai 1 - Mun 1 - E1" + BRK +
			"CEP:11111-111 Tel (11) 1111-1111" + BRK +
			"" + BRK +
			"CNPJ: 11.111.111/1111-11" + BRK +
			"IE: 123456789" + BRK;

	@BeforeAll
	public static void setup() {
		CupomFiscal.NOME_LOJA = "Loja 1";
		CupomFiscal.LOGRADOURO = "Log 1";
		CupomFiscal.NUMERO = 10;
		CupomFiscal.COMPLEMENTO = "C1";
		CupomFiscal.BAIRRO = "Bai 1";
		CupomFiscal.MUNICIPIO = "Mun 1";
		CupomFiscal.ESTADO = "E1";
		CupomFiscal.CEP = "11111-111";
		CupomFiscal.TELEFONE = "(11) 1111-1111";
		CupomFiscal.OBSERVACAO = "Obs 1";
		CupomFiscal.CNPJ = "11.111.111/1111-11";
		CupomFiscal.INSCRICAO_ESTADUAL = "123456789";
	}

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno(TEXTO_ESPERADO_LOJA_COMPLETA);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		verificarCampoObrigatorio("O campo nome da loja é obrigatório");
		CupomFiscal.NOME_LOJA = "Loja 1";
	}

	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		verificarCampoObrigatorio("O campo logradouro do endereço é obrigatório");
		CupomFiscal.LOGRADOURO = "Log 1";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_NUMERO);
		CupomFiscal.NUMERO = 10;
	}

	@Test
	public void complementoVazio() {
		CupomFiscal.COMPLEMENTO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_COMPLEMENTO);
		CupomFiscal.COMPLEMENTO = "C1";
	}

	@Test
	public void bairroVazio() {
		CupomFiscal.BAIRRO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_BAIRRO);
		CupomFiscal.BAIRRO = "Bai 1";
	}

	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		verificarCampoObrigatorio("O campo município do endereço é obrigatório");
		CupomFiscal.MUNICIPIO = "Mun 1";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		verificarCampoObrigatorio("O campo estado do endereço é obrigatório");
	    CupomFiscal.ESTADO = "E1";
	}

	@Test
	public void cepVazio() {
		CupomFiscal.CEP = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_CEP);
	    CupomFiscal.CEP = "11111-111";
	}

	@Test
	public void telefoneVazio() {
		CupomFiscal.TELEFONE = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_TELEFONE);
	    CupomFiscal.TELEFONE = "(11) 1111-1111";
	}

	@Test
	public void observacaoVazia() {
		CupomFiscal.OBSERVACAO = "";
		rodarTestarRetorno(TEXTO_ESPERADO_SEM_OBSERVACAO);
	    CupomFiscal.OBSERVACAO = "Obs 1";
	}

	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		verificarCampoObrigatorio("O campo CNPJ da loja é obrigatório");
	    CupomFiscal.CNPJ = "11.111.111/1111-11";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		verificarCampoObrigatorio("O campo inscrição estadual da loja é obrigatório");
		CupomFiscal.INSCRICAO_ESTADUAL = "123456789";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Loja CRVG";
		CupomFiscal.LOGRADOURO = "R. Gen. Almério de Moura";
		CupomFiscal.NUMERO = 131;
		CupomFiscal.COMPLEMENTO = "Estádio";
		CupomFiscal.BAIRRO = "São Januário";
		CupomFiscal.MUNICIPIO = "Rio de Janeiro";
		CupomFiscal.ESTADO = "RJ";
		CupomFiscal.CEP = "20921060";
		CupomFiscal.TELEFONE = "(21) 91898-1927";
		CupomFiscal.OBSERVACAO = "Obs 1";
		CupomFiscal.CNPJ = "12.111.333/12133-12";
		CupomFiscal.INSCRICAO_ESTADUAL = "123.456.789.000";
		
		//E atualize o texto esperado abaixo
		rodarTestarRetorno("Loja CRVG" + BRK + 
		"R. Gen. Almério de Moura, 131 Estádio" + BRK + 
		"São Januário - Rio de Janeiro - RJ" + BRK + 
		"CEP:20921060 Tel (21) 91898-1927" + BRK + 
		"Obs 1" + BRK + 
		"CNPJ: 12.111.333/12133-12" + BRK + 
		"IE: 123.456.789.000" + BRK);
	}
	private void rodarTestarRetorno(String expected) {

		// action
		String retorno = CupomFiscal.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}
	
	private void verificarCampoObrigatorio(String mensagemEsperada) {
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals(mensagemEsperada, e.getMessage());
		}
	}
	
}