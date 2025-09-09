import random

def quicksort(arr):
    if len(arr) <= 1:
        return arr
    # Escolhe um pivô aleatoriamente
    pivot_index = random.randint(0, len(arr) - 1)
    pivot = arr[pivot_index]
    # Remove o pivô da lista
    arr = arr[:pivot_index] + arr[pivot_index+1:]
    # Divide em menores e maiores
    menores = [x for x in arr if x <= pivot]
    maiores = [x for x in arr if x > pivot]
    # Recursivamente ordena as partições
    return quicksort(menores) + [pivot] + quicksort(maiores)

# Exemplo de uso:
if __name__ == "__main__":
    lista = [10, 7, 8, 9, 1, 5]
    print("Lista original:", lista)
    print("Lista ordenada:", quicksort(lista))
