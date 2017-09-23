import org.grouplens.lenskit.iterative.IterationCount
import org.grouplens.lenskit.iterative.StoppingCondition
import org.grouplens.lenskit.iterative.ErrorThresholdStoppingCondition
import org.grouplens.lenskit.iterative.MinimumIterations
import org.grouplens.lenskit.iterative.StoppingThreshold

import org.lenskit.api.ItemScorer

import org.lenskit.mf.funksvd.FeatureCount

import org.lenskit.pf.HPFItemScorer
import org.lenskit.pf.IterationFrequency
import org.lenskit.pf.IsProbabilityPrediciton
import org.lenskit.data.entities.CommonTypes
import org.lenskit.data.ratings.EntityCountRatingVectorPDAO
import org.lenskit.data.ratings.InteractionEntityType
import org.lenskit.data.ratings.RatingVectorPDAO
import org.lenskit.pf.RandomSeed

bind ItemScorer to HPFItemScorer
bind RatingVectorPDAO to EntityCountRatingVectorPDAO
set InteractionEntityType to CommonTypes.RATING

set IterationFrequency to 10
set IterationCount to 200
set FeatureCount to 100
set RandomSeed to System.currentTimeMillis()
