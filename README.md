# matheus.bressani.Lumiere

## CI

O workflow executa `./mvnw -B verify` em pull requests e em pushes para `main`, usando Java 21 Temurin.

- Run vermelho controlado (asserção falsa): [35290948508](https://github.com/BressaniEND/matheus.bressani.Lumiere/actions/runs/35290948508)
- Run verde após o revert: [35290867534](https://github.com/BressaniEND/matheus.bressani.Lumiere/actions/runs/35290867534)
- Validação local: `./mvnw -B verify` (54 testes aprovados)