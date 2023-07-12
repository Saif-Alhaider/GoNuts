package com.example.gonuts.usecase

import com.example.gonuts.data.DoughnutDataSource
import com.example.gonuts.entity.Doughnut
import javax.inject.Inject

class GetDoughnutByNameUseCase @Inject constructor(private val doughnutDataSource: DoughnutDataSource) {
    operator fun invoke(name: String): Doughnut {
        return (doughnutDataSource.todayOffers + doughnutDataSource.doughnuts)
            .first { it.name == name }
    }
}