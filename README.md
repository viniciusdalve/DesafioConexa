# DesafioConexa

- Este projeto ele pesquisa filme da franquia Star Wars na api "https://swapi.dev/", através de um endpoint GET, e os adiciona em um banco de dados H2, com
a alternativa que se não encontrar o filme desejado, ele irá incluir as informações deste filme no banco de dados H2 da mesma forma. 
Recursos: Pesquisa por titulo ou id do episodio. Paginacao de 10 itens.
Testes unitarios implementados.

-Estou utilizando:
Java 17
SpringBoot 3.0.4
Maven

A utilização deste projesto consiste em colnar ele para a máquina desejada, executa-lo e chamar o endpont:
"http://localhost:8080/v1/starwars/films?title=exemplo&episode_id=exemplo"

Observacoes de versao

Na execucao atual em uma maquina diferente da qual eu criei o projeto o projeto encontra-se um erro generico de beans em que
nao consegui resolver por hora e prazo de entrega.

Mas na versao do dia 22.03.2023 o projeto funcionava corretamente na maquina em que foi criado.

