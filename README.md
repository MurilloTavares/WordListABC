# WordListABC
Atividade acadêmica sobre geração de wordlist:
Esse projeto tem como objetivo gerar uma wordlist de palavras sem repetição formadas pelos conjuntos:
- A={0,1,2,3,4,5,6,7}
- B= {a,e,i,o,u}
- C={b,c,d,f,g,h,j,l,m,n,p,q,r,s,t,v,x,z,k,y}

Sendo que a palavra contenha 3 pares de consoante e vogal (sílabas) e 2 números do conjunto A.

### A classe WordListGenerator ###
A classe WordListGenerator gera a wordlist através do método `generate(int limit)`, sendo passado como
parâmetro o limite do tamanho da wordlist, para evitar erros de falta de memória, devido a quantidade de palavras
ser muito grande nesse caso.

O método **generate** possui 3 pares de foreach para gerar os 3 pares de consoante e 1 par para iterar sobre os números:
- O primeiro par de foreach, itera sobre a **lista original** pegando uma consoante e uma vogal, formando a primeira
sílaba;
- O segundo par de foreach itera sobra a **lista original menos a consoante e a vogal que já foi utilizada**,
ou seja, a lista restante, para excluir repetições e formando a segunda sílaba;
- Da mesma forma, o terceiro par de foreach também itera sobre a segunda lista gerada, excluindo repetiçes e formando a
terceira e ultima sílaba;
- O último par de foreach serve para iterar e pegar 2 números do conjunto A, sendo o primeiro foreach o conjunto A original
e o segundo foreach (dentro do primeiro) iterando sobre o conjunto A original menos o número já utilizando, para excluir
repetições;
- E por fim, é adicionado dentro da wordlist todas as combinações de sílabas e números possíveis, nesse caso: AACBCBCB,
ACBACBCB, ACBCBACB, ACBCBCBA, CBAACBCB, CBACBACB, CBACBCBA, CBCBAACB, CBCBACBA, CBCBCBAA, sendo cada letra representando
seu respectivo conjunto, totalizando uma soma de 10 posições diferentes.
