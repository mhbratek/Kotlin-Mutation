package com.codingflower

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk


class MutationsTest : ShouldSpec({
    should("return true if value is bigger than zero") {
        val mutation = Mutations(mockk())

        mutation.isPositive(20) shouldBe true
        mutation.isPositive(-20) shouldBe false
        mutation.isPositive(0) shouldBe false
    }

    should("return data from DB") {
        val mockedDB = mockk<MutationDataProvider>()
        val mutation = Mutations(mockedDB)
        val expected = Something("Mocked!")

        every { mockedDB.getData() } returns expected

        mutation.getMutatedData() shouldBe expected
    }
})