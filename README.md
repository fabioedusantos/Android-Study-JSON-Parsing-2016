# Android-Study-JSON-Parsing-2016

Aplicativo Android desenvolvido como material de apoio para demonstrar a leitura e a decodificação de dados em **JSON** utilizando as classes `JSONArray` e `JSONObject` disponíveis no Android.

O exemplo foi preparado para aulas dos cursos de **Sistemas de Informação da FACOL, em Lençóis Paulista/SP**, e **Técnico em Informática da ETEC Rodrigues de Abreu, em Bauru/SP — Centro Paula Souza**.

## Objetivo da aula

O projeto apresenta, de forma direta, como receber uma `String` contendo dados JSON, transformá-la em objetos manipuláveis pelo Java e acessar seus valores para utilizá-los na interface do aplicativo.

O exemplo trabalha com uma lista de usuários representada por um array JSON:

```json
[
  {"usuario": "John", "senha": "Doe"},
  {"usuario": "Anna", "senha": "Smith"},
  {"usuario": "Peter", "senha": "Jones"}
]
```

Ao pressionar o botão **Ler JSON**, a aplicação percorre os registros e apresenta os valores de `usuario` e `senha` nos respectivos `TextView`.

## Conteúdos abordados

- estrutura e sintaxe básica de JSON;
- diferença entre objeto e array JSON;
- criação de `JSONArray` a partir de uma `String`;
- obtenção de um `JSONObject` dentro de um array;
- leitura de propriedades com `getString()`;
- uso de `length()` para percorrer um `JSONArray`;
- tratamento de `JSONException`;
- atualização de componentes `TextView` com os dados decodificados;
- uso de `Log` para registrar erros de interpretação do JSON.

## Fluxo do exemplo

```text
String JSON
    │
    ▼
new JSONArray(json)
    │
    ▼
for (...) sobre os registros
    │
    ▼
getJSONObject(i)
    │
    ├── getString("usuario")
    └── getString("senha")
    │
    ▼
TextView
```

## Principais classes utilizadas

### `JSONArray`

Representa uma coleção ordenada de valores JSON. No projeto, a `String` de exemplo começa com `[` e contém três objetos.

```java
JSONArray jsonArray = new JSONArray(json);
```

A quantidade de elementos pode ser obtida com:

```java
jsonArray.length();
```

E cada posição é recuperada como um `JSONObject`:

```java
JSONObject jsonObj = jsonArray.getJSONObject(i);
```

### `JSONObject`

Representa um objeto JSON composto por pares de chave e valor. Cada item do array possui as chaves `usuario` e `senha`.

```java
String usuario = jsonObj.getString("usuario");
String senha = jsonObj.getString("senha");
```

Para uma `String` que represente diretamente um objeto JSON, a leitura pode começar com:

```java
JSONObject jsonObject = new JSONObject(json);
```

## Tratamento de erros

As operações de leitura podem lançar `JSONException` quando o conteúdo informado não possui uma estrutura JSON válida ou quando uma chave esperada não está disponível.

O exemplo captura essa exceção e registra a mensagem no Logcat:

```java
catch (final JSONException e) {
    Log.d("app", "JSONException: " + e.getMessage());
}
```

## Interface

A tela é composta por:

- um botão **Ler JSON**;
- três pares de `TextView` para exibir usuário e senha;
- um `ScrollView` envolvendo o conteúdo.

O botão utiliza o atributo `android:onClick` para chamar diretamente o método:

```java
public void ler(View v)
```

## Estrutura principal

```text
app/
└── src/main/
    ├── java/br/fabio/jsonteste/
    │   └── MainActivity.java
    ├── res/
    │   ├── layout/
    │   │   └── activity_main.xml
    │   └── values/
    └── AndroidManifest.xml
```

## Ambiente do projeto

O projeto utiliza:

- Java;
- Android SDK 24;
- `minSdkVersion 15`;
- `targetSdkVersion 24`;
- Android Gradle Plugin 2.2.0;
- Gradle 2.14.1;
- Android AppCompat 24.2.0.

## Executando o exemplo

1. Abra o projeto no Android Studio.
2. Aguarde a sincronização do Gradle.
3. Execute o aplicativo em um dispositivo ou emulador Android.
4. Pressione **Ler JSON**.
5. Observe os três usuários sendo preenchidos na tela.

## Exercícios propostos

A partir do exemplo, podem ser realizados exercícios como:

- alterar os nomes das propriedades do JSON;
- adicionar novos campos aos objetos;
- aumentar a quantidade de registros do array;
- apresentar os registros em uma `ListView`;
- testar uma `String` contendo somente um `JSONObject`;
- validar o comportamento ao informar um JSON inválido.

---

Material acadêmico desenvolvido por **Fábio Eduardo dos Santos** em 2016.  
