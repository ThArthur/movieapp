# 🎬 TMDB Movies App

Um aplicativo Android moderno desenvolvido com **Jetpack Compose** que consome a [API do TMDB](https://www.themoviedb.org/) para exibir filmes populares, top-rated e em cartaz. O projeto segue as práticas recomendadas de arquitetura Android com **Hilt**, **Paging 3**, **Retrofit**, e muito mais.

---

## ✨ Funcionalidades

- 🔍 Listagem de filmes populares, em alta e em cartaz
- 📄 Detalhes do filme com descrição, nota, poster e data
- 🔄 Paginação automática com **Paging Compose**
- 🌗 Suporte a tema claro e escuro
- 📡 Comunicação com a TMDB via **Retrofit + Gson**
- 📷 Carregamento de imagens com **Coil**
- 🧭 Navegação declarativa com **Navigation Compose**
- 💉 Injeção de dependência com **Hilt**
- ✅ Testes básicos de UI com `ui-test-android`

---

## 🛠️ Tecnologias e bibliotecas

| Tecnologia | Uso |
|------------|-----|
| [Jetpack Compose](https://developer.android.com/jetpack/compose) | UI declarativa |
| [Paging Compose](https://developer.android.com/jetpack/androidx/releases/paging) | Paginação de listas |
| [Navigation Compose](https://developer.android.com/jetpack/compose/navigation) | Navegação entre telas |
| [Retrofit2](https://square.github.io/retrofit/) + [Gson](https://github.com/google/gson) | Comunicação com APIs |
| [OkHttp](https://square.github.io/okhttp/) | Cliente HTTP |
| [Coil](https://coil-kt.github.io/coil/compose/) | Carregamento de imagens |
| [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) | Injeção de dependência |
| [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization) | (Opcional) Serialização JSON |
| [Compose UI Test](https://developer.android.com/jetpack/compose/testing) | Testes de interface |

---
