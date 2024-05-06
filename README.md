# Sobre o projeto
Teste executados na pagina https://the-internet.herokuapp.com/challenging_dom visando desafios envolvendo locators em meio a DOM.

## Ambiente para execucao
Utilizado JDK11 para construcao da automacao. Chromedriver ja incluso nos arquivos do projeto.
- Executar comando maven mvn clean install
- Baixar fonte e recursos do projeto atravez da aba do maven na IDE

### Execucao
- Instalar MAVEN conforme tutorial https://dicasdeprogramacao.com.br/como-instalar-o-maven-no-windows/
- Para execucao simples, acessar src>main>java>br.challengingDOM>suites>SuiteTest e executar a classe SuiteTest
- Para execucao com paralelismo, configurado para rodar os dois cenarios ao msm tempo em drivers distintos, rodar o comando no maven mvn test
