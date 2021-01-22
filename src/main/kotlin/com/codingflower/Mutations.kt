package com.codingflower

class Mutations(
    private val mutationDataProvider: MutationDataProvider
) {
    fun isPositive(value: Int): Boolean {
        return value > 0
    }

    fun getMutatedData(): Something {
        return mutationDataProvider.getData()
    }
}