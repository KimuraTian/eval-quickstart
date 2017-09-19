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
import org.lenskit.pf.RandomSeed
import org.lenskit.data.entities.CommonTypes
import org.lenskit.data.ratings.EntityCountRatingVectorPDAO
import org.lenskit.data.ratings.InteractionEntityType
import org.lenskit.data.ratings.RatingVectorPDAO

bind ItemScorer to HPFItemScorer

bind RatingVectorPDAO to EntityCountRatingVectorPDAO
set InteractionEntityType to CommonTypes.RATING

set IterationFrequency to 10
set IterationCount to 125
set RandomSeed to System.currentTimeMillis()

for (k in[25,30,35,40,45,50,60,70,80,90,100,120,140,160,180,200,225,250]) {
    algorithm("PF") {
        attributes["FeatureCount"] = k
        set FeatureCount to k
    }
}