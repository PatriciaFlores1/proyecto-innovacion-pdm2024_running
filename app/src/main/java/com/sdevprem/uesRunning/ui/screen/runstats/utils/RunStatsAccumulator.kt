package com.sdevprem.uesRunning.ui.screen.runstats.utils

import com.sdevprem.uesRunning.core.data.model.Run
import com.sdevprem.uesRunning.ui.screen.runstats.RunStatsUiState.AccumulatedRunStatisticsOnDate
import java.util.Date

object RunStatsAccumulator {

    fun accumulateRunByDate(
        list: List<Run>
    ): Map<Date, AccumulatedRunStatisticsOnDate> {
        return buildMap {
            list.forEach { run ->
                val newStats = AccumulatedRunStatisticsOnDate.fromRun(run)
                this[newStats.date] = newStats + this[newStats.date]
            }
        }
    }

}