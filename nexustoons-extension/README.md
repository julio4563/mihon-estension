# NexusToons — Extensão para Mihon/Komikku

Extensão do site [nexustoons.com](https://nexustoons.com) para o leitor de mangá **Mihon** (e forks como Komikku).

---

## Como usar (sem instalar nada no PC)

### Passo 1 — Criar conta no GitHub
Acesse [github.com](https://github.com) e crie uma conta gratuita se ainda não tiver.

### Passo 2 — Fazer fork deste repositório
Clique em **Fork** no canto superior direito desta página.
Isso cria uma cópia do repositório na sua conta.

### Passo 3 — Criar uma keystore (necessário para assinar o APK)

Você precisa de uma keystore para assinar o APK. Gere uma rodando este comando no seu PC (requer Java instalado) ou use o [Keytool Online](https://keystore-explorer.org/):

```bash
keytool -genkey -v \
  -keystore minha-keystore.jks \
  -alias nexustoons \
  -keyalg RSA \
  -keysize 2048 \
  -validity 10000
```

Anote a senha que você escolher.

Depois, converta o arquivo `.jks` para base64:
```bash
base64 -w 0 minha-keystore.jks
```

### Passo 4 — Adicionar os Secrets no GitHub

No seu fork, vá em **Settings > Secrets and variables > Actions > New repository secret** e adicione:

| Nome | Valor |
|------|-------|
| `KEY_STORE` | O texto base64 do passo anterior |
| `KEY_ALIAS` | `nexustoons` (ou o alias que você escolheu) |
| `KEY_STORE_PASSWORD` | A senha da keystore |
| `KEY_PASSWORD` | A senha da chave (pode ser igual à keystore) |

### Passo 5 — Rodar o build

Vá em **Actions > Build NexusToons Extension > Run workflow**.

Aguarde uns 5-10 minutos. Quando terminar, o APK vai aparecer na aba **Releases**.

### Passo 6 — Instalar no celular

Baixe o APK da aba **Releases** e instale no Android.
No Mihon, ele vai aparecer como uma extensão instalada em **Browse > Extensions**.

---

## Estrutura do projeto

```
.github/workflows/build.yml   — CI que compila e publica o APK
src/main/kotlin/.../NexusToons.kt — Código da extensão
build.gradle                  — Config do build
```

## Atualizações

Sempre que você der push no `main`, o GitHub Actions vai recompilar e publicar uma nova versão automaticamente.
