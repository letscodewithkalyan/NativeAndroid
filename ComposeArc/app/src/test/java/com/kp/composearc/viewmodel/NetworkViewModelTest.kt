package com.kp.composearc.viewmodel

import com.kp.composearc.data.datasources.network.NetworkResult
import com.kp.composearc.data.model.UserModel
import com.kp.composearc.data.repository.FakerRepository
import com.kp.composearc.presentation.viewmodels.NetworkViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class NetworkViewModelTest {
    private val fakerRepository: FakerRepository = mockk()
    
    @get: Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `userData updated from repository`() = runTest {
        //Arrange
        val fakeUsers =
            listOf(UserModel(123L, "test", "test", "test", "test", "test", "test", "test"))
        val expectedResult = NetworkResult.Success(fakeUsers)

        coEvery { fakerRepository.getUsers() } returns expectedResult

        //Act
        val viewModel = NetworkViewModel(fakerRepository)
        advanceUntilIdle() // Let init{} coroutine finish

        //Assert
        assertEquals(expectedResult, viewModel.userData.value)
    }
}

class MainCoroutineRule(val dispatcher : TestDispatcher = StandardTestDispatcher()) : TestWatcher() {
    private val testDispatcher = StandardTestDispatcher()

    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun succeeded(description: Description?) {
        super.succeeded(description)
        Dispatchers.resetMain()
    }
}