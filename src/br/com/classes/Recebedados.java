package br.com.classes;

import java.util.Date;

public class Recebedados {

	private String nomeAluno;
	private String nomeMae;
	private String endereco;
	private String cidade;
	private String estado;
	private String CEP;
	private Date dtNascimento;
	private String CPF;
	private String telefone;
	private String RG;
	private String sexo;
	@SuppressWarnings("unused")
	private String checkdM;
	@SuppressWarnings("unused")
	private String checkdF;
	
	public String getNomeAluno() {
		return nomeAluno !=null ? nomeAluno : "";
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
	public String getNomeMae() {
		return nomeMae != null ? nomeMae : "";
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getEndereco() {
		return endereco !=null ? endereco : "";
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCidade() {
		return cidade !=null ? cidade : "";
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado !=null ? estado : "";
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCEP() {
		return CEP !=null ? CEP : "";
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	public Date getDtNascimento() {
		return (Date) (dtNascimento !=null ? dtNascimento : "") ;
	}
	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getCPF() {
		return CPF !=null ? CPF : "";
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getTelefone() {
		return telefone !=null ? telefone : "";
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getRG() {
		   return RG != null ? RG : "";
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public String getSexo() {
		return sexo != null ? sexo : "";
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getCheckdM() {
		return this.sexo == "f" ? "" : "checked";
	}

	public String getCheckdF() {
		return this.sexo  == "m" ? "" : "checked";
	}


}

