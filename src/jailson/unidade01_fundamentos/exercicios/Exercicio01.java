package jailson.unidade01_fundamentos.exercicios;

// Unidade 1, itens 14 a 16 — laboratório de pensamento de QA.
// A atividade original é teórica; o programa apresenta a resolução escrita.
public class Exercicio01 {
    public static void main(String[] args) {
        System.out.println("""
# U01 — Laboratório 1: Pense como QA
**Disciplina:** Java — Quality assurance · **Aluno:** Elton Da Silva Paz  
**Origem:** itens 14–16 da Unidade 1 no Gennera.

## Parte A — Perguntas de investigação
O requisito recebido informa apenas que o visitante poderá criar uma conta com nome, e-mail, idade e senha. As perguntas abaixo precisam ser respondidas pelo time; não representam regras já aprovadas.

1. Nome é obrigatório? Quais comprimentos mínimo e máximo e quais caracteres são aceitos?
2. Espaços externos no nome serão removidos? Um nome composto com acentos será preservado?
3. Quais formatos de e-mail serão aceitos e será necessária confirmação do endereço?
4. Como será tratada a criação de outra conta com o mesmo e-mail, inclusive com maiúsculas e espaços externos?
5. Qual é a idade mínima e máxima? O limite é inclusivo e a entrada aceita somente números inteiros?
6. A idade será informada diretamente ou calculada pela data de nascimento? Como será tratada uma idade negativa?
7. Quais são os comprimentos mínimo e máximo da senha e existe alguma outra restrição?
8. A confirmação da senha precisa coincidir exatamente, inclusive em maiúsculas, minúsculas e espaços?
9. Aceitar os termos é obrigatório? Qual mensagem e estado do formulário aparecem quando não são aceitos?
10. Em qual momento cada campo é validado e como a mensagem identifica o campo a corrigir?
11. Dois cliques em Criar conta ou o reenvio após uma demora podem criar contas duplicadas? Como o serviço garante unicidade?
12. O que ocorre se o servidor concluir o cadastro, mas o navegador não receber a resposta?
13. Qual tempo de resposta é aceitável e em quais condições de carga, rede e dispositivo ele será medido?
14. O cadastro inteiro pode ser concluído pelo teclado, com foco visível e mensagens compreensíveis por leitor de tela?
15. Quais tamanhos de tela e navegadores precisam ser suportados?
16. Como senha e dados pessoais serão protegidos no transporte, no armazenamento e nos registros de diagnóstico?

## Parte B — Riscos e impactos
A prioridade é uma avaliação inicial, sujeita a refinamento conforme probabilidade e impacto reais.

| ID | Risco | Possível impacto | Prioridade inicial |
|---|---|---|---|
| R01 | E-mail duplicado ou cadastro repetido em dois cliques | Identidade fragmentada e problemas para recuperar a conta | Alta |
| R02 | Idade negativa ou abaixo do limite ser aceita | Cadastro incompatível com a regra de elegibilidade | Alta |
| R03 | Pessoa exatamente na idade mínima ser rejeitada | Exclusão indevida de público autorizado | Alta |
| R04 | Senha e confirmação divergirem | Usuário não conseguir acessar a conta recém-criada | Alta |
| R05 | Dados sensíveis aparecerem em logs ou mensagens | Exposição desnecessária de credenciais e dados pessoais | Alta |
| R06 | Falha de comunicação depois de salvar a conta | Reenvio e dúvida sobre a conclusão do cadastro | Alta |
| R07 | Navegação por teclado sem foco visível | Pessoa não conseguir identificar ou operar o campo atual | Alta |
| R08 | Botão ficar inacessível no celular | Impedimento de concluir o fluxo em um contexto suportado | Alta |
| R09 | Demora sem indicação de progresso | Abandono e cliques repetidos | Média |
| R10 | Mensagem técnica não orientar a correção | Repetição do erro e aumento de chamados | Média |

## Parte C — Classificação dos casos A–H
Os comportamentos são fictícios, fornecidos pelo enunciado. Não foram observados em um site real.

| Caso | Classificação inicial | Justificativa e próximo passo |
|---|---|---|
| A — e-mail abc aceito | Possível problema funcional; investigar | O texto não parece um endereço de e-mail. Confirmar a política de formato, localizar a validação e tentar reproduzir com dados controlados. |
| B — azul de que não gosto | Preferência pessoal | Gosto individual não comprova defeito. Uma possível violação objetiva de contraste ou identidade visual exigiria outro critério e outra análise. |
| C — idade -15 aceita | Possível problema funcional | Idade negativa não representa uma idade humana válida; confirmar domínio e forma de entrada. Não atribuir causa sem evidência. |
| D — sem foco visual na senha | Possível problema de usabilidade/acessibilidade | A pessoa navega pelo teclado, mas não sabe visualmente onde está. Verificar todo o fluxo e os requisitos de acessibilidade. |
| E — cadastro demora 35 s | Possível problema de desempenho; investigar | Registrar condições e repetições e comparar com o objetivo acordado. Só o número isolado não informa carga, rede nem prazo aceito. |
| F — dois cliques criam duas contas iguais | Possível problema funcional | O resultado indica duplicação no cenário simulado. Investigar unicidade e repetição de requisições sem concluir qual camada é responsável. |
| G — 18 anos rejeitados | Possível problema funcional | Há conflito direto com a regra explícita de 18 anos ou mais. Verificar 17, 18 e 19 anos. |
| H — mensagem Error 500 | Possível problema de usabilidade; investigar funcionalidade | Não orienta o usuário; há também um possível erro de serviço. Coletar contexto e identificação do evento sem expor detalhes internos. |

## Parte D — Três registros estruturados
**Natureza das evidências:** registros analíticos dos casos fictícios do enunciado. Não são resultados de execução nem capturas de uma aplicação.

### E01 — Limite de idade (caso G)
- **Funcionalidade:** criação de conta, validação de idade.
- **Condição:** no cenário descrito, enviar dados válidos e idade exatamente 18.
- **Resultado esperado:** aceitar a idade, pois a regra diz 18 anos ou mais.
- **Resultado encontrado:** o enunciado relata que o cadastro foi bloqueado.
- **Impacto possível:** impedir uma pessoa elegível de criar sua conta.
- **A investigar:** mensagem exibida, dados enviados, regra implementada e resultados para 17 e 19.

### E02 — Envio repetido (caso F)
- **Funcionalidade:** persistência da criação de conta.
- **Condição:** no cenário descrito, clicar duas vezes rapidamente em Criar conta com os mesmos dados.
- **Resultado esperado proposto para validar com o time:** somente uma conta para aquela identidade e retorno compreensível para o reenvio.
- **Resultado encontrado:** o enunciado relata duas contas iguais.
- **Impacto possível:** duplicidade, inconsistência de identidade e retrabalho no suporte.
- **A investigar:** identificadores das contas e requisições, horários e política de unicidade; repetir somente em ambiente de teste.

### E03 — Indicação de foco (caso D)
- **Funcionalidade:** navegação pelo teclado no cadastro.
- **Condição:** avançar com Tab até o campo Senha.
- **Resultado esperado proposto:** foco visual identificável e interação pelo teclado, conforme os critérios de acessibilidade definidos para o produto.
- **Resultado encontrado:** o enunciado informa que o foco não tem indicação visual.
- **Impacto possível:** dificuldade para compreender a posição atual e concluir o cadastro.
- **A investigar:** sequência de foco, estados visuais, navegador e comparação com o protótipo.

## Parte E — Reflexão (8 linhas)
Um cadastro correto demonstra apenas que uma combinação de dados percorreu um caminho.  
Outras pessoas podem informar campos vazios, valores no limite ou dados incompatíveis.  
O produto também precisa tratar repetição de envio e problemas de comunicação.  
A interface pode funcionar no computador e impedir a operação no celular.  
Uma pessoa que utiliza teclado pode enfrentar dificuldades não vistas com o mouse.  
Uma resposta lenta ou uma mensagem incompreensível também compromete a experiência.  
QA precisa esclarecer regras, relacionar riscos e registrar observações objetivas.  
Assim, os testes aumentam a confiança nos cenários verificados sem comprovar ausência total de defeitos.

## Checklist da entrega
- 16 perguntas concretas; 10 riscos com impacto.
- Casos A–H classificados e justificados.
- Três registros com condição, esperado, encontrado e impacto.
- Fatos, propostas e hipóteses identificados.
- Reflexão apresentada; nenhuma causa atribuída a uma pessoa.

""");
    }
}
