import org.grouplens.lenskit.iterative.StoppingCondition
import org.grouplens.lenskit.iterative.ErrorThresholdStoppingCondition
import org.grouplens.lenskit.iterative.MinimumIterations
import org.grouplens.lenskit.iterative.StoppingThreshold

import org.lenskit.api.ItemScorer

import org.lenskit.mf.funksvd.FeatureCount

import org.lenskit.pf.HPFItemScorer
import org.lenskit.pf.IterationFrequency
import org.lenskit.pf.Splitproportion


bind ItemScorer to HPFItemScorer
bind StoppingCondition to ErrorThresholdStoppingCondition
set IterationFrequency to 100
set MinimumIterations to 200
set StoppingThreshold to 0.000001
set FeatureCount to 100
set Splitproportion to 0.01