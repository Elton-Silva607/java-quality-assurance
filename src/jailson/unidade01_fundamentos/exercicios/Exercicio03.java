package jailson.unidade01_fundamentos.exercicios;

// Unidade 1, itens 22 — atividade de recuperação.
// A atividade original é teórica; o programa apresenta a resolução escrita.
public class Exercicio03 {
    public static void main(String[] args) {
        System.out.println("""
# U01 — Recuperação: qualidade na recuperação de senha
**Origem:** item 22.

## Cinco riscos
| Risco | Impacto |
|---|---|
| Resposta revelar se o e-mail está cadastrado | Facilitar enumeração de contas |
| Solicitações repetidas sem controle | Envio excessivo de mensagens e indisponibilidade |
| Link incorreto, sem expiração ou reutilizável | Falha de acesso ou recuperação indevida |
| Falha do serviço sem orientação compreensível | Usuário acreditar que o pedido foi concluído ou ficar sem alternativa |
| Formulário inutilizável no celular ou teclado | Impedir recuperação em um contexto de uso |

## Cinco perguntas
1. Qual resposta deve ser exibida para e-mail existente e inexistente para evitar exposição de contas?
2. Quanto tempo o link deve durar e o que acontece ao usá-lo novamente?
3. Existe limite de solicitações por intervalo? Como o usuário é orientado quando o atinge?
4. Quais regras definem campo vazio, formato válido e tratamento de espaços?
5. Como representar envio em andamento, erro de serviço e eventual atraso na entrega em telas pequenas e leitores de tela?

## Três comportamentos a investigar
1. **E-mail existente e inexistente:** comparar mensagens e respostas conforme a política aprovada; para uma conta de teste existente, verificar recebimento e funcionamento do link.
2. **Campo vazio e formato inválido:** verificar impedimento de envio, mensagem associada ao campo e preservação do foco.
3. **Repetição e indisponibilidade:** simular solicitações consecutivas e falha controlada do serviço; verificar controle acordado, ausência de pedidos duplicados e retorno compreensível, também no celular.

## Testar funcionamento e investigar qualidade
Testar se funciona pode se restringir a pedir uma recuperação para um endereço válido e abrir o link. Investigar qualidade inclui revisar critérios, privacidade, limites, tratamento de falhas, acessibilidade e uso em dispositivos diferentes. As propostas precisam ser acordadas com o time; não se devem inventar duração do token ou quantidade de solicitações como se já fossem requisitos.

""");
    }
}
