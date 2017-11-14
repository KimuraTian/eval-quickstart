import org.grouplens.lenskit.iterative.IterationCount
import org.grouplens.lenskit.iterative.StoppingCondition
import org.grouplens.lenskit.iterative.ErrorThresholdStoppingCondition
import org.grouplens.lenskit.iterative.MinimumIterations
import org.grouplens.lenskit.iterative.StoppingThreshold

import org.lenskit.api.ItemScorer

import org.lenskit.mf.funksvd.FeatureCount

import org.lenskit.pf.HPFItemScorer
import org.lenskit.pf.ConvergenceCheckFrequency
import org.lenskit.pf.IsProbabilityPrediciton
import org.lenskit.data.entities.CommonTypes
import org.lenskit.data.ratings.EntityCountRatingVectorPDAO
import org.lenskit.data.ratings.InteractionEntityType
import org.lenskit.data.ratings.RatingVectorPDAO

bind ItemScorer to HPFItemScorer

set ConvergenceCheckFrequency to 10
set IterationCount to 200
set FeatureCount to 100
set IsProbabilityPrediciton to false