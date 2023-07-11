def read_input(file_name):
    with open(file_name, "r") as file:
        lines = file.readlines()
        N, K = map(int, lines[0].strip().split())
        items = [tuple(map(int, line.strip().split())) for line in lines[1:]]
    return N, K, items

def knapsack(N, K, items):
    dp = [[0] * (K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        weight, value = items[i - 1]
        for j in range(K + 1):
            if weight <= j:
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - weight] + value)
            else:
                dp[i][j] = dp[i - 1][j]

    return dp

def traceback(dp, N, K, items):
    result = [0] * N
    W, V = 0, dp[N][K]

    for i in range(N, 0, -1):
        if dp[i][K] != dp[i - 1][K]:
            result[i - 1] = 1
            weight = items[i - 1][0]
            W += weight
            K -= weight

    return W, V, result

def write_output(file_name, W, V, result):
    with open(file_name, "w") as file:
        file.write(f"{W}\t{V}\n")
        file.write("\t".join(str(x) for x in result))

def main():
    N, K, items = read_input("input.txt")
    dp = knapsack(N, K, items)
    W, V, result = traceback(dp, N, K, items)
    write_output("solution.txt", W, V, result)

if __name__ == "__main__":
    main()