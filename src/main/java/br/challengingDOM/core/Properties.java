package br.challengingDOM.core;

public class Properties {
    public static boolean FECHAR_BROWSER = true;
    public static Browsers BROWSER = Browsers.CHROME;
    public static TipoExecucao TIPO_EXECUCAO = TipoExecucao.LOCAL;

    public enum Browsers{
        CHROME
    }

    public enum TipoExecucao{
        LOCAL
    }
}
