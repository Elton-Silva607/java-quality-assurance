package jailson.unidade01_fundamentos.exercicios;

// Unidade 1, itens 17 — desafio profissional de checkout.
// A atividade original é teórica; o programa apresenta a resolução escrita.
public class Exercicio02 {
    public static void main(String[] args) {
        System.out.println("""
# U01 — Desafio: incidente no checkout da TechStore
**Origem:** itens 17–18. **Relato recebido:** um cliente afirma que pagou duas vezes.

## 1. Cinco perguntas
1. Qual forma de pagamento foi utilizada?
2. As duas ocorrências são cobranças efetivadas ou uma delas é uma autorização temporária?
3. As duas cobranças estão ligadas ao mesmo pedido, valor e tentativa de compra?
4. Em qual data, horário e fuso ocorreram, e o cliente repetiu a ação após demora ou mensagem de erro?
5. Por qual canal, versão da aplicação e dispositivo a compra foi realizada, e o cenário voltou a ocorrer?

## 2. Cinco informações ou evidências úteis
1. Identificador do pedido e referência interna da conta, acessíveis apenas à equipe autorizada.
2. Identificadores das duas transações e seus estados no provedor, sem número completo do cartão.
3. Linha do tempo com horários, fuso, valor e eventos de autorização, captura, estorno e confirmação.
4. Registros correlacionados das requisições, identificadores de reenvio e notificações do provedor.
5. Mensagens ou imagens do fluxo e descrição dos passos, com dados sensíveis ocultados.

## 3. Três hipóteses iniciais
- **Hipótese 1:** pode ter ocorrido reenvio da mesma intenção de compra por duplo clique ou repetição após tempo de espera, sem tratamento adequado de duplicidade.
- **Hipótese 2:** pode haver duas autorizações no extrato e apenas uma cobrança efetivada; os estados precisam ser confirmados no provedor.
- **Hipótese 3:** uma notificação ou requisição pode ter sido processada novamente, criando duas operações para o mesmo pedido.

Nenhuma hipótese é causa comprovada. É necessário correlacionar as evidências e reproduzir de forma controlada, quando possível.

## 4. Explicação profissional
“Pagamento está bugado” não informa pedido, horário, contexto, forma de pagamento, resultado esperado nem resultado encontrado. A equipe não consegue distinguir cobrança duplicada, autorização pendente ou dois pedidos diferentes. Um registro útil descreve o relato como relato, apresenta referências verificáveis e separa os fatos confirmados das hipóteses. A investigação deve preservar a privacidade e evitar novas cobranças reais.

## Próximo passo de investigação
Confirmar o estado financeiro das duas transações com a equipe responsável, correlacionar pedido e eventos e tentar reproduzir em ambiente de teste. Se o comportamento não for reproduzido, registrar o que foi verificado e manter a incerteza explícita.

""");
    }
}
