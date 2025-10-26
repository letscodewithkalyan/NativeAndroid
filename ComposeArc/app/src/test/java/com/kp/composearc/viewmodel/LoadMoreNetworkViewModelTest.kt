package com.kp.composearc.viewmodel

import androidx.lifecycle.viewmodel.compose.viewModel
import com.kp.composearc.data.datasources.network.NetworkResult
import com.kp.composearc.data.model.UserModel
import com.kp.composearc.data.repository.FakerRepository
import com.kp.composearc.presentation.viewmodels.LoadMoreNetworkViewModel
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LoadMoreNetworkViewModelTest {
    private val fakerRepository: FakerRepository = mockk()

    @Before
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun loadData_internet_success() = runTest {
        val mockData = listOf(UserModel(12L, "", "", "", "", "", "", ""))
        val expected = NetworkResult.Success(mockData)
        coEvery { fakerRepository.getUsers(1) }.returns(expected)


        val loadMoreNetworkViewModel = LoadMoreNetworkViewModel(fakerRepository)
        loadMoreNetworkViewModel.loadUsers()
        advanceUntilIdle()

        assertEquals(mockData, loadMoreNetworkViewModel.userData.value)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}
