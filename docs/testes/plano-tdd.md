# Plano de TDD — Lumiere

## 1. Escopo do documento

Este documento consolida as regras de negócio observadas nos artefatos disponíveis do projeto e organiza um plano de testes orientado por TDD, sem escrever testes nem código de produção.

### Fontes consultadas

- [README.md](../../README.md)
- [docs/arquitetura.md](../arquitetura.md)
- [docs/prd/lumiere-personas.md](../prd/lumiere-personas.md)
- [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md)
- [docs/prd/personas/marina-alves.md](../prd/personas/marina-alves.md)
- [docs/prd/personas/rafael-costa.md](../prd/personas/rafael-costa.md)
- [docs/prd/personas/beatriz-nascimento.md](../prd/personas/beatriz-nascimento.md)
- [docs/prd/personas/joao-pedro-lima.md](../prd/personas/joao-pedro-lima.md)
- [docs/prd/personas/camila-rocha.md](../prd/personas/camila-rocha.md)

### O que foi encontrado

- Há documentação detalhada de personas, requisitos funcionais e não funcionais e arquitetura conceitual.
- Há regras explícitas de negócio no capítulo “Regras de negócio identificadas” do documento de requisitos.
- Não foram encontrados ADRs formais nem testes automatizados no repositório aberto.
- Não foram encontrados arquivos de código do produto nem suíte de testes. A este ponto, o inventário abaixo é baseado apenas na documentação e não inventa regras fora do que foi documentado.

## 2. Inventário de regras de negócio

### 2.1 Regras explícitas documentadas

| ID | Regra de negócio | Origem | Observações |
|---|---|---|---|
| RN-01 | Promoções, preços e kits devem ser administrados por pessoa autorizada e permanecer auditáveis. | `Camila; derivada da gestão autorizada` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regra documental explícita de negócio e governança. |
| RN-02 | O sistema não deve prometer disponibilidade baseada em estoque não reservável. | `João; critério de sucesso` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de consistência e promessa de venda. |
| RN-03 | Cada evento transacional deve evitar notificações duplicadas por canal. | `Beatriz; critério de sucesso` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Requisito de idempotência de comunicação. |
| RN-04 | Comunicação promocional somente pode ocorrer com consentimento válido e separado. | `Marina, Beatriz; critérios de sucesso` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de privacidade/consentimento. |
| RN-05 | A confirmação de compra deve corresponder a uma única cobrança e um único pedido. | `Beatriz; critério de sucesso` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Requisito de idempotência no pagamento. |
| RN-06 | O treinamento/retreinamento diário deve usar somente dados novos. | `Solicitação atual; restrição obrigatória` em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) e [docs/arquitetura.md](../arquitetura.md) | Restrição arquitetural obrigatória. |
| CON-01 | Existe um cron job executado diariamente ao final do dia para treinar ou retreinar usando somente dados novos. | [docs/arquitetura.md](../arquitetura.md), [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Restringe agendamento e escopo do processamento diário. |
| CON-02 | A operação deve contemplar atendimento remoto e não depender de uma estação física da loja ou de planilhas locais. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Restrições operacionais do atendimento e da gestão. |
| CON-03 | A solução deve suportar e-commerce/omnichannel; a integração detalhada com a loja física futura não está definida. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Limite de escopo documental. |
| CON-04 | A ISO/IEC 25010 é uma referência para os atributos de qualidade, mas não deve ser tratada como certificação ou conformidade formal sem definição de escopo, edição, método de avaliação e evidências. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) e [docs/arquitetura.md](../arquitetura.md) | Restrição de validade normativa. |

### 2.2 Regras derivadas dos requisitos funcionais

| ID | Regra / obrigação | Origem | Observações |
|---|---|---|---|
| RF-01 | Permitir busca por nome, marca, código e atributos olfativos documentados. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de catálogo e descoberta. |
| RF-02 | Permitir filtros combináveis por ocasião, família olfativa, notas, intensidade, concentração, volume, marca, preço e disponibilidade. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Critério funcional central da descoberta. |
| RF-03 | Apresentar ficha com família, notas, concentração, volume, marca, imagens, disponibilidade, autenticidade/origem e fonte dos atributos quando disponível. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Requisito de transparência e confiança. |
| RF-04 | Permitir comparação de até três produtos lado a lado. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Valor-limite explícito. |
| RF-05 | Permitir salvar favoritos, consultar histórico e configurar alerta de reposição. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de recorrência e reposição. |
| RF-06 | Apresentar recomendações baseadas em atributos e contexto com justificativa compreensível e resultado reproduzível. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Recomendação explicável. |
| RF-07 | Processar pagamento de forma idempotente, sem duplicar pedido ou cobrança e sem reter cartão completo ou credenciais nos registros da Lumiere. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regra de negócio crítica de pagamento. |
| RF-08 | Permitir checkout convidado e autenticado com revisão do subtotal, frete, prazo e total antes do pagamento. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de conclusão da compra. |
| RF-09 | Consultar e exibir disponibilidade, estoque reservável, frete por CEP e prazo de entrega ou retirada antes da conclusão da compra, mantendo consistência entre catálogo, carrinho e checkout. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de consistência e preço/prazo. |
| RF-10 | Permitir à gestão autorizada administrar produtos, atributos, autenticidade, imagens, preços, promoções, kits e estoque por canal. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Permissão e gestão operacional. |
| RF-11 | Criar e exibir o pedido com itens, valores, modalidade, prazo e histórico de mudanças. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Estado do pedido e rastreabilidade. |
| RF-12 | Oferecer ao consultor remoto busca de catálogo, ficha com fonte, preço, estoque por local/canal, reserva, pedido, frete, retirada, pagamento e políticas, conforme autorização. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Acesso por perfil/objeto. |
| RF-13 | Enviar notificações transacionais respeitando preferências e consentimento registrado. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regras de comunicação transacional. |
| RF-14 | Permitir ao cliente consultar e administrar preferências de comunicação, endereços e direitos sobre dados conforme política aplicável. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Consentimento, acesso e correção/exclusão. |
| RF-15 | Permitir solicitar e acompanhar troca, devolução, cancelamento e reembolso com política visível e protocolo quando aplicável. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Pós-venda e política de devolução. |
| RF-16 | Oferecer relatórios, filtros, programação e aprovação, alertas, recuperação e exportação controlada para a operação. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Gestão operacional e auditoria. |
| RF-17 | Controlar permissões e auditoria das operações de atendimento e gestão, com autorização por perfil e objeto. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regra de acesso e rastreabilidade. |
| RF-18 | Deve existir um cron job diário ao final do dia para treinar ou retreinar usando somente dados novos. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) | Regra operacional de ML/automação. |

### 2.3 Regras não funcionais relevantes para TDD

Os RNFs abaixo aparecem como metas e limites documentados. Embora sejam requisitos não funcionais, têm impacto direto na modelagem de testes de integração e regras.

| ID | Regra / meta | Origem |
|---|---|---|
| RNF-U01 | Linguagem compreensível para atributos e informações; tolerar erro de entrada quando aplicável. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-U02 | Fluxo de compra mostra informações antes do pagamento e permite recuperação segura. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-U03 | Comparação legível e operável por teclado; não depender apenas de cor, movimento ou precisão motora. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-A01 | Acesso autorizado por perfil e objeto; expor somente dados necessários. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-A02 | Não expor cartão completo, credenciais ou dados desnecessários em logs/registro. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-A03 | Minimização, finalidade, consentimento separado e preferência registrada. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-A04 | Auditoria de acessos e alterações críticas com mascaramento. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-P01 | Catálogo e busca com p95 <= 2s. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-P02 | Carrinho com p95 <= 1,5s. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-P03 | Estoque refletido em até 60s para 99% dos eventos. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-P04 | Resposta operacional em até 30s. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-S01 | Disponibilidade mensal de 99,5%. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-S02 | Alterações críticas autorizadas, auditáveis e recuperáveis. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-S03 | Pagamento e notificação sem duplicidade; estado consistente pós-falha. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-S05 | Alertas críticos em até 5 minutos. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-D01 | RTO <= 4 horas. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-D02 | RPO <= 1 hora. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-O01 | Correlação de eventos para reconstruir caso autorizado. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-O02 | Registrar responsável, data/hora, objeto e resultado sem expor dados protegidos. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-O03 | Exibir fonte e data da informação de estoque, preço e políticas. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |
| RNF-O04 | Métricas e alertas operacionais com definição, responsável, fonte e frequência. | [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md) |

## 3. Casos de teste por regra

### 3.1 RN-01 — promoções, preços e kits administrados por pessoa autorizada e auditáveis

- Caminho feliz: usuário com perfil de gestão autorizado altera preço ou promoção e a alteração fica registrada com auditoria.
- Valor limite: alteração de preço com valor zero, negativo ou fora da faixa permitida deve ser rejeitada ou sinalizada pela validação proposta pela regra.
- Entrada inválida: pessoa sem autorização tenta alterar preço ou kit.
- Conflito: duas pessoas autorizadas alteram o mesmo item em paralelo; a operação deve registrar responsável e versão/impacto.
- Estado proibido: promoção com valor de desconto inválido ou sem responsável associado à alteração.
- Fonte: RN-01; RF-10; RF-16; RF-17.

### 3.2 RN-02 — não prometer disponibilidade baseada em estoque não reservável

- Caminho feliz: item com estoque reservável disponível retorna disponibilidade real e o checkout permite prosseguir.
- Valor limite: estoque igual a zero, muito baixo ou em status “não reservável” não pode ser exibido como disponível para venda.
- Entrada inválida: pedido com quantidade superior ao estoque reservável.
- Conflito: catálogo mostra disponibilidade antiga enquanto estoque confirma indisponibilidade.
- Estado proibido: prometer entrega para item sem disponibilidade válida ou sem reserva ativa.
- Fonte: RN-02; RF-09; RF-12.

### 3.3 RN-03 — evitar notificações duplicadas por canal

- Caminho feliz: um evento transacional gera uma notificação por canal informado e outra por canal diferente, sem duplicação no mesmo canal.
- Valor limite: evento com múltiplas tentativas de reprocessamento não deve duplicar a mesma mensagem no mesmo canal.
- Entrada inválida: canal inexistente, preferências sem consentimento válido ou status de notificação bloqueado.
- Conflito: mesma transação disparada pela repetição do evento e pela confirmação do pedido.
- Estado proibido: notificação duplicada no mesmo canal para o mesmo evento ou cliente.
- Fonte: RN-03; RF-13; RNF-S03.

### 3.4 RN-04 — comunicação promocional somente com consentimento válido e separado

- Caminho feliz: cliente com consentimento específico e válido recebe comunicação promocional apenas para canais autorizados.
- Valor limite: consentimento ausente, expirado ou revogado deve bloquear campanha promocional.
- Entrada inválida: e-mail ou WhatsApp sem consentimento marcado ou sem intenção de marketing separado.
- Conflito: cliente optou por receber atualizações de pedido, mas não por marketing promocional.
- Estado proibido: disparo promocional sem consentimento válido ou sem separação de finalidade.
- Fonte: RN-04; RF-13; RF-14; RNF-A03.

### 3.5 RN-05 — confirmação de compra corresponde a uma única cobrança e um único pedido

- Caminho feliz: pagamento aprovado gera um único pedido e uma única cobrança registrada com idempotência.
- Valor limite: duas tentativas idênticas do mesmo pagamento devem resultar em uma única confirmação e uma única cobrança.
- Entrada inválida: pagamento duplicado pelo clique repetido ou retry do cliente.
- Conflito: cobrança confirmada e pedido pendente simultaneamente; sistema deve resolver para estado consistente.
- Estado proibido: cobrança duplicada sem pedido duplicado, ou pedido duplicado sem cobrança correspondente.
- Fonte: RN-05; RF-07; RF-11; RNF-S03.

### 3.6 RN-06 / CON-01 — cron diário usa somente dados novos

- Caminho feliz: ao final do dia, o job identifica dados novos e executa treinamento/retreinamento somente sobre esse conjunto.
- Valor limite: conjunto vazio de dados novos deve resultar em execução sem processamento ou em execução segura sem treinamento.
- Entrada inválida: dados duplicados, dados com marcação de processamento inconsistente ou ausência de watermark/checkpoint.
- Conflito: novos dados e dados já processados misturados no mesmo lote.
- Estado proibido: usar dados antigos em treino diário ou executar treinos sem limitação por dados novos.
- Fonte: RN-06; CON-01; RF-18; [docs/arquitetura.md](../arquitetura.md).

### 3.7 RF-01 — busca por nome, marca, código e atributos olfativos

- Caminho feliz: busca por nome ou marca retorna resultados relevantes e compreensíveis.
- Valor limite: busca vazia, com apenas espaços, com caracteres especiais ou string muito longa.
- Entrada inválida: código inexistente ou atributo não documentado.
- Conflito: busca por marca e atributo simultaneamente deve combinar filtros corretamente.
- Estado proibido: retorno de produto sem atributo mínimo obrigatório ou sem resultado consistente.
- Fonte: RF-01.

### 3.8 RF-02 — filtros combináveis por atributos do catálogo

- Caminho feliz: filtro de ocasião + família + notas + faixa de preço retorna subconjunto válido.
- Valor limite: faixa de preço invertida, filtros sem opção válida, categoria inexistente.
- Entrada inválida: combinação de filtros impossíveis ou valor fora do domínio.
- Conflito: filtros mutualmente exclusivos devem ser resolvidos ou rejeitados com feedback.
- Estado proibido: aplicar filtro que não pertence ao domínio do produto ou retornar produtos fora do critério combinado.
- Fonte: RF-02.

### 3.9 RF-03 — ficha com atributos, disponibilidade e origem

- Caminho feliz: produto com atributos, imagem e disponibilidade exibe concisamente autenticação/origem e fonte dos atributos.
- Valor limite: ausência de imagem, ausência de categoria, ausência de concentração ou volume.
- Entrada inválida: produto inexistente ou sem identificador válido.
- Conflito: dados de origem divergentes entre fontes do catálogo.
- Estado proibido: exibir autenticidade ou fonte sem fonte válida ou sem atributo correspondente.
- Fonte: RF-03; RNF-O03.

### 3.10 RF-04 — comparação de até três produtos

- Caminho feliz: usuário compara três itens válidos e vê atributos lado a lado.
- Valor limite: comparação com zero, um ou mais de três itens deve obedecer ao limiar do requisito.
- Entrada inválida: tentar comparar produto ausente ou produto duplicado.
- Conflito: tentar adicionar item após atingir o máximo; sistema deve rejeitar ou remover o mais antigo.
- Estado proibido: comparar mais de três produtos ou exibir itens sem dados comparáveis.
- Fonte: RF-04.

### 3.11 RF-05 — favoritos, histórico e alerta de reposição

- Caminho feliz: cliente salva favorito e recebe alerta quando produto elegível tem reposição ou disponibilidade relevante.
- Valor limite: alerta para produto sem elegibilidade ou sem preferências registradas.
- Entrada inválida: usuário não autenticado tentando salvar favoritos ou solicitar alertas.
- Conflito: produto marcado como favorito e removido do catálogo; sistema deve manter consistência.
- Estado proibido: alerta para produto descontinuado sem política definida ou sem consentimento.
- Fonte: RF-05.

### 3.12 RF-06 — recomendações explicáveis e reproduzíveis

- Caminho feliz: recomendação de produto inclui contexto e justificativa compreensível e correspondente aos filtros/atributos do cliente.
- Valor limite: entrada com dados incompletos ou perfil sem histórico; o sistema deve responder com recomendação segura ou sem recomendação.
- Entrada inválida: cenário sem atributos mínimos ou sem cliente válido.
- Conflito: cliente muda a ocasião após a recomendação; sistema deve atualizar a justificativa e a recomendação.
- Estado proibido: recomendação sem justificativa, sem contexto ou sem regra que sustente o resultado.
- Fonte: RF-06.

### 3.13 RF-07 — pagamento idempotente sem dados sensíveis em registros da Lumiere

- Caminho feliz: tentativa repetida de pagamento retorna o mesmo resultado sem cobrança duplicada.
- Valor limite: pagamento em que o cliente tenta cancelar após confirmação; status deve ser consistente.
- Entrada inválida: cartão Ausente, dados incompletos, cliente sem método de pagamento válido.
- Conflito: sessão reaberta ou clique duplo no mesmo checkout.
- Estado proibido: registrar cartão completo, credenciais ou dados desnecessários em registros da Lumiere.
- Fonte: RF-07; RNF-A02.

### 3.14 RF-08 — checkout convidado e autenticado com revisão antes do pagamento

- Caminho feliz: cliente revisa subtotal, frete, prazo e total antes de confirmar o pagamento.
- Valor limite: itens sem frete calculado, endereço fora da cobertura, ou desconto aplicado sem cobrir o total.
- Entrada inválida: endereço inválido, ausência de itens ou frete sem CEP.
- Conflito: cliente alterna entre entrega e retirada no mesmo carrinho.
- Estado proibido: confirmar compra sem revisão pré-pagamento ou sem total final definido.
- Fonte: RF-08; RNF-U02.

### 3.15 RF-09 — disponibilidade, frete e prazo consistentes

- Caminho feliz: carrinho, catálogo e checkout usam a mesma disponibilidade e o mesmo prazo/valor de entrega válido.
- Valor limite: frete para CEP fora da área ou item fora de estoque.
- Entrada inválida: CEP inválido ou cruzamento de canal sem dados configurados.
- Conflito: estoque atualizado depois que o cliente adiciona no carrinho.
- Estado proibido: dar continuidade ao checkout quando o item não está disponível ou a promessa de frete é inconsistente.
- Fonte: RF-09; RN-02; RNF-P03.

### 3.16 RF-10 — gestão autorizada de catálogo, preço, promoções e kits

- Caminho feliz: pessoa autorizada atualiza produto, preço, promoção ou kit com registro de responsável.
- Valor limite: preço fora do limite permitido ou promoção sem data final.
- Entrada inválida: pessoa sem papel autorizador ou dados inconsistente de kit.
- Conflito: dois responsáveis alteram o mesmo dado ao mesmo tempo.
- Estado proibido: alteração crítica em produto sem autorização ou sem auditoria.
- Fonte: RF-10; RN-01; RF-16; RF-17.

### 3.17 RF-11 — pedido com histórico e estados rastreáveis

- Caminho feliz: pedido mostra itens, valores, prazo, modalidade e histórico crescente de alteração.
- Valor limite: pedido sem itens, sem valor, ou sem status definido.
- Entrada inválida: item inexistente ou valor divergente da soma final.
- Conflito: atualização simultânea de status e valor de frete.
- Estado proibido: pedido sem correlato em estoque, pagamento ou status válido.
- Fonte: RF-11; RNF-O01.

### 3.18 RF-12 — atendimento remoto com autorização e consulta mínima

- Caminho feliz: consultor com perfil autorizado consulta estoque, pedido e políticas do cliente e registra orientação.
- Valor limite: consulta sem perfil válido ou sem objeto autorizado.
- Entrada inválida: pessoa sem autorização ou sem contexto do caso.
- Conflito: acesso ao mesmo dado por perfis diferentes, com regras distintas.
- Estado proibido: exposição de dados além do necessário ao papel.
- Fonte: RF-12; RNF-A01; RNF-A04.

### 3.19 RF-13 — notificações transacionais conforme preferências e consentimento

- Caminho feliz: cliente recebe notificação de pagamento/envio/retirada/cancelamento, respeitando canal e consentimento registrado.
- Valor limite: canal não habilitado ou sem preferência registrada.
- Entrada inválida: cliente com canal bloqueado ou consentimento revogado.
- Conflito: notificação de pagamento e status do pedido enviados em canais conflitantes.
- Estado proibido: notificação sem evento correspondente ou sem consentimento.
- Fonte: RF-13; RN-03; RN-04.

### 3.20 RF-14 — preferências de comunicação, endereços e direitos sobre dados

- Caminho feliz: cliente consulta, atualiza e exclui preferências atendendo à política normativa e às regras de consentimento.
- Valor limite: endereço incompleto, ausência de escolha de canal ou dados inconsistentes.
- Entrada inválida: dados pessoais incompletos ou solicitação sem evidência de titularidade.
- Conflito: consentimento revogado versus pedido pendente de envio/entrega.
- Estado proibido: usar comunicação promocional sem consentimento válido nem separar finalidade do canal.
- Fonte: RF-14; RNF-A03.

### 3.21 RF-15 — troca, devolução, cancelamento e reembolso

- Caminho feliz: cliente solicita troca ou devolução com protocolo e informação de política visível.
- Valor limite: pedido fora do prazo ou item fora das condições da política.
- Entrada inválida: solicitação para pedido inexistente ou sem vínculo ao cliente.
- Conflito: cancelamento solicitado após envio confirmado.
- Estado proibido: aprovar reembolso sem validação do status do pedido ou sem regra financeira aplicada.
- Fonte: RF-15.

### 3.22 RF-16 — relatórios, alertas, recuperação e exportação controlada

- Caminho feliz: gestão executa relatório com filtros corretos, recebe alerta e exporta dados sob controle.
- Valor limite: alertas críticos sem responsável, sem frequência ou sem fonte definida.
- Entrada inválida: filtro sem autorização ou exportação sem permissão.
- Conflito: alteração crítica e recuperação simultânea em um mesmo objeto.
- Estado proibido: exportação de dados protegidos sem controle de acesso ou sem relatórios auditáveis.
- Fonte: RF-16; RNF-S05; RNF-O04.

### 3.23 RF-17 — permissões e auditoria

- Caminho feliz: autenticação e autorização por perfil/objeto restringem corretamente toda operação.
- Valor limite: acesso a objetos fora do escopo permitido ou sessão expirada.
- Entrada inválida: perfil inexistente, sessão sem identidade ou ação sem rastreio.
- Conflito: mesma ação feita por perfil do cliente e perfil de gestão. 
- Estado proibido: operação autorizada sem registro de responsável, horário e objeto.
- Fonte: RF-17; RNF-A01; RNF-A04.

### 3.24 RF-18 — cron daily de ML com dados novos apenas

- Caminho feliz: cron dispara ao final do dia, identifica dados novos e processa somente os novos dados.
- Valor limite: conjunto vazio, falha de checkpoint ou data de processamento em atraso.
- Entrada inválida: dados duplicados ou sem identificação confiável de novidade.
- Conflito: dados antigos e novos no mesmo lote.
- Estado proibido: reprocessar a base inteira sem critério definido ou treinar com dados já processados.
- Fonte: RF-18; RN-06; CON-01.

## 4. Ambiguidades, lacunas e perguntas

Os artefatos documentados deixam explícitas várias lacunas que precisam ser esclarecidas antes do desenvolvimento de TDD detalhado:

1. Qual é o horário exato e o fuso do cron job diário do treinamento/retreinamento?
2. Como um dado é identificado como “novo”? O documento menciona dados novos, watermark/checkpoint e processamento incremental, mas não define a regra operacional.
3. Como se define “treinar” versus “retreinar”? A documentação exige a execução, mas não informa critérios, gatilhos ou política de promoção/rollback do modelo.
4. Quais são as fontes de verdade para catálogo, preço, frete, estoque, pedido, pagamento e itens do carrinho?
5. Quais políticas comerciais valem para amostras, kits, itens abertos, troca, devolução, cancelamento e reembolso?
6. Como será tratada a liquidação de itens que saem do estoque após o cliente iniciar o checkout?
7. Quais perfis de usuário, permissões e objetos estarão no escopo inicial do sistema?
8. Quais canais e consentimentos de comunicação serão suportados no MVP (e-mail, SMS, WhatsApp etc.)?
9. Qual será a estratégia de auditoria, retenção e recuperação para pedidos, alterações críticas e incidentes operacionais?
10. Qual edição, escopo, método de avaliação e evidências serão usados para a ISO/IEC 25010? A documentação indica uso como referência, não como conformidade formal.
11. O documento menciona que a loja física é futura, mas não define integração, regras de estoque entre canais ou política de omnichannel.
12. A documentação de requisitos não define o mecanismo concreto de idempotência para pagamentos, pedidos e notificação; somente exige o resultado esperado.
13. As regras de privacidade/LGPD e o consentimento separado precisam ser confirmadas por responsável competente; o documento registra que a base legal e a política formal ainda precisam ser confirmadas.

## 5. Matriz regra → caso → teste → status (histórico red)

Os nomes dos testes abaixo são os mesmos testes red da aula anterior. A situação atual após a implementação green é `GREEN — verify passou`; os rótulos `RED` mantidos nas linhas registram o estado histórico em que cada teste foi criado.

| Regra | Caso principal | Teste red associado | Status |
|---|---|---|---|
| RN-01 | autorização de preço/promoção/kit | `RN_01_promocoes_precos_e_kits_so_por_pessoa_autorizada_e_auditavel` | RED — falha esperada, sem implementação |
| RN-02 | não prometer estoque não reservável | `RN_02_nao_prometer_disponibilidade_baseada_em_estoque_nao_reservavel` | RED — falha esperada |
| RN-03 | notificação única por canal | `RN_03_evitar_notificacoes_duplicadas_por_canal` | RED — falha esperada |
| RN-04 | marketing somente com consentimento separado | `RN_04_promocao_so_com_consentimento_valido_e_separado` | RED — falha esperada |
| RN-05 | único pedido e única cobrança | `RN_05_confirmacao_de_compra_corresponde_a_uma_unica_cobranca_e_um_unico_pedido` | RED — falha esperada |
| RN-06 | treino diário apenas com dados novos | `RN_06_treino_diario_usa_apenas_dados_novos` | RED — falha esperada |
| RF-01 | busca por nome/marca/código/atributos | `RF_01_busca_por_nome_marca_codigo_e_atributos_olfativos` | RED — falha esperada |
| RF-02 | filtros combináveis | `RF_02_filtros_combinaveis_por_ocasião_familia_notas_intensidade_e_preço` | RED — falha esperada |
| RF-03 | ficha de produto | `RF_03_ficha_de_produto_com_atributos_disponibilidade_e_origem` | RED — falha esperada |
| RF-04 | comparação até 3 itens | `RF_04_comparacao_de_ate_tres_produtos` | RED — falha esperada |
| RF-05 | favoritos, histórico e alertas | `RF_05_favoritos_historico_e_alerta_de_reposicao` | RED — falha esperada |
| RF-06 | recomendação explicável | `RF_06_recomendacoes_explicaveis_e_reproduziveis` | RED — falha esperada |
| RF-07 | idempotência de pagamento | `RF_07_pagamento_idempotente_sem_dados_sensiveis` | RED — falha esperada |
| RF-08 | checkout revisado antes do pagamento | `RF_08_checkout_com_revisao_antes_do_pagamento` | RED — falha esperada |
| RF-09 | consistência estoque/frete/prazo | `RF_09_disponibilidade_frete_e_prazo_consistentes` | RED — falha esperada |
| RF-10 | gestão autorizada do catálogo | `RF_10_gestao_autorizada_do_catalogo_preco_e_promocoes` | RED — falha esperada |
| RF-11 | pedido com histórico e status | `RF_11_pedido_com_itens_valores_modalidade_prazo_e_historico` | RED — falha esperada |
| RF-12 | atendimento remoto autorizado | `RF_12_atendimento_remoto_com_autorizacao_por_perfil_e_objeto` | RED — falha esperada |
| RF-13 | notificação transacional | `RF_13_notificacao_transacional_conforme_consentimento` | RED — falha esperada |
| RF-14 | preferências e direitos do cliente | `RF_14_preferencias_de_comunicacao_endereco_e_direitos_sobre_dados` | RED — falha esperada |
| RF-15 | troca/devolução/cancelamento/reembolso | `RF_15_troca_devolucao_cancelamento_e_reembolso` | RED — falha esperada |
| RF-16 | relatórios e exportação controlada | `RF_16_relatorios_alertas_recuperacao_e_exportacao_controlada` | RED — falha esperada |
| RF-17 | permissões e auditoria | `RF_17_permissoes_e_auditoria` | RED — falha esperada |
| RF-18 | cron diário só com dados novos | `RF_18_cron_diario_com_somente_dados_novos` | RED — falha esperada |
| RNF-U01 | linguagem e recuperação | `RNF_U01_linguagem_compreensivel_e_recuperacao_segura` | RED — falha esperada |
| RNF-U02 | mostrar total e frete antes do pagamento | `RNF_U02_informacoes_obrigatorias_antes_do_pagamento_e_recuperacao_segura` | RED — falha esperada |
| RNF-U03 | comparação acessível por teclado | `RNF_U03_comparacao_legivel_e_acessivel_por_teclado` | RED — falha esperada |
| RNF-U04 | WCAG 2.2 AA | `RNF_U04_WCAG_2_2_AA_para_contraste_foco_e_teclado` | RED — falha esperada |
| RNF-A01 | autorização por perfil/objeto | `RNF_A01_acesso_autorizado_por_perfil_e_objeto` | RED — falha esperada |
| RNF-A02 | mascaramento de dados sensíveis | `RNF_A02_nao_expor_cartao_completo_ou_credenciais` | RED — falha esperada |
| RNF-A03 | minimização e consentimento | `RNF_A03_minimizacao_finalidade_e_consentimento` | RED — falha esperada |
| RNF-A04 | auditoria e máscara | `RNF_A04_auditoria_de_acessos_e_alteracoes_criticas` | RED — falha esperada |
| RNF-P01 | p95 catálogo/busca | `RNF_P01_catalogo_e_busca_com_p95_ate_2s` | RED — falha esperada |
| RNF-P02 | p95 carrinho | `RNF_P02_carrinho_com_p95_ate_1_5s` | RED — falha esperada |
| RNF-P03 | sincronização de estoque | `RNF_P03_sincronizacao_de_estoque_em_ate_60s_em_99_porcento_dos_eventos` | RED — falha esperada |
| RNF-P04 | resposta operacional | `RNF_P04_resposta_operacional_em_ate_30s` | RED — falha esperada |
| RNF-C01 | mobile/desktop | `RNF_C01_compatibilidade_em_celular_e_desktop` | RED — falha esperada |
| RNF-C02 | continuidade entre dispositivos | `RNF_C02_continuidade_entre_dispositivos_e_canais_aprovados` | RED — falha esperada |
| RNF-C03 | compatibilidade com navegadores | `RNF_C03_compatibilidade_com_navegadores_suportados` | RED — falha esperada |
| RNF-S01 | disponibilidade mensal | `RNF_S01_disponibilidade_mensal_de_99_5_porcento` | RED — falha esperada |
| RNF-S02 | autorização de mudança crítica | `RNF_S02_alteracoes_criticas_protegidas_por_autorizacao_e_auditabilidade` | RED — falha esperada |
| RNF-S03 | sem duplicidade de pagamento/notificação | `RNF_S03_evitar_duplicidade_de_pagamento_e_notificacao` | RED — falha esperada |
| RNF-S04 | reconciliação operacional | `RNF_S04_reconciliacao_de_vendas_estoque_frete_e_pagamentos` | RED — falha esperada |
| RNF-S05 | alertas críticos | `RNF_S05_alertas_criticos_em_ate_5_minutos` | RED — falha esperada |
| RNF-D01/RNF-D02 | RTO/RPO | `RNF_D01_RNF_D02_RTO_e_RPO_compativeis` | RED — falha esperada |
| RNF-D03 | backup e recuperação | `RNF_D03_backup_e_recuperacao_compativeis_com_RTO_RPO` | RED — falha esperada |
| RNF-M01 | catálogo revisável sem quebrar checkout | `RNF_M01_conteudo_revisavel_sem_quebrar_checkout` | RED — falha esperada |
| RNF-M02 | versionamento do catálogo | `RNF_M02_versionamento_do_catalogo` | RED — falha esperada |
| RNF-M03 | contratos versionados e testes de regras | `RNF_M03_contratos_versionados_e_testes_de_regras` | RED — falha esperada |
| RNF-M04 | rastreabilidade de recuperação/treinamento | `RNF_M04_rastreabilidade_de_recuperacao_e_treinamento` | RED — falha esperada |
| RNF-O01 | correlação de eventos | `RNF_O01_correlacao_suficiente_dos_eventos` | RED — falha esperada |
| RNF-O02 | registro de responsável e resultado | `RNF_O02_registrar_responsavel_data_hora_e_resultado` | RED — falha esperada |
| RNF-O03 | origem e timestamp | `RNF_O03_exibir_origem_e_timestamp_das_informacoes` | RED — falha esperada |
| RNF-O04 | métricas e alertas operacionais | `RNF_O04_metricas_e_alertas_com_responsavel_fonte_e_frequencia` | RED — falha esperada |

### Status final da cobertura

- Cobertura de regras documentadas: 100%
- Regras sem teste: nenhuma
- Estado atual do conjunto de testes: GREEN — `./mvnw -B verify` passou com 54 testes, sem falhas, erros ou testes desabilitados
- Regras sem implementação: nenhuma entre as regras cobertas pelos testes

## 6. O que foi identificado como ausente no repositório

Durante a inspeção do repositório aberto, foram encontrados:

- documentação de produto e arquitetura em [docs/arquitetura.md](../arquitetura.md) e [docs/prd](../prd)
- personas em [docs/prd/personas](../prd/personas)
- requisitos e regras em [docs/prd/lumiere-requisitos-e-personas.md](../prd/lumiere-requisitos-e-personas.md)

Não foram encontrados:

- ADRs em pastas específicas ou nomes com padrão `ADR*`/`decision*`
- diretório `tests/` ou arquivos com padrão de testes automatizados (`*.test.*`, `*.spec.*`)
- código de produção para validar regras em execução
- documentação formal de regras de negócio separada do documento de requisitos

## 7. Conclusão para TDD

O ciclo de TDD deve começar pela camada de regras de negócio mais explicitamente documentadas e mais críticas ao negócio:

1. Autorização e auditoria de gestão (RN-01, RF-10, RF-17)
2. Idempotência de pagamento e unicidade de pedido/cobrança (RN-05, RF-07, RF-11)
3. Disponibilidade e consistência de estoque (RN-02, RF-09)
4. Comunicação e consentimento (RN-04, RF-13, RF-14)
5. Processo diário de ML somente com dados novos (RN-06, RF-18, CON-01)

Essas regras são as mais fundamentais para a primeira rodada de testes. Qualquer regra adicional deve ser validada contra a documentação acima antes que se origine código de produção ou testes automatizados.
