/*
	Programa:  primeiro.c
	Autor:     Daniel Nocito
	Data:      20/04/2020
	Descrição: Este programa resolve a eq do primeiro
		           grau  ax + b = 0
*/

#include<stdio.h>
int main ( void ) {
	float a, /* coef da eq */
		  b, /* termo independente da eq */
		  x; /* resultado da eq */

	printf("Este programa resolve uma equação de primeiro grau.\n");
	printf("Entre com o coeficiente a, por favor: ");
	scanf ("%f", &a);
	printf("Entre com o coeficiente b, por favor: ");
	scanf ("%f", &b);

	if ( a == 0 ) {
		printf("Esta equação não tem solução.\n");
	}
	else {
		x = -b/a;
		printf("A solução da equação vale %1.3f\n", x);
	}

	return 0;
}
