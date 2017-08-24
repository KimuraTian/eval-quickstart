import org.grouplens.lenskit.transform.threshold.RealThreshold
import org.grouplens.lenskit.transform.threshold.Threshold
import org.lenskit.api.ItemScorer
import org.lenskit.baseline.BaselineScorer
import org.lenskit.baseline.ItemMeanRatingItemScorer
import org.lenskit.knn.item.ModelSize
import org.lenskit.knn.item.MinCommonUsers
import org.lenskit.knn.item.ItemSimilarityThreshold
import org.lenskit.slim.MinItemWeight
import org.lenskit.slim.SLIMItemScorer
import org.lenskit.slim.RidgeRegressionTerm
import org.lenskit.slim.SLIMBuildContext
import org.lenskit.slim.SLIMBuildContextProvider

import org.lenskit.transform.normalize.BaselineSubtractingUserVectorNormalizer
import org.lenskit.transform.normalize.UserVectorNormalizer
import org.lenskit.slim.RidgeRegressionTerm
import org.grouplens.lenskit.iterative.StoppingCondition
import org.grouplens.lenskit.iterative.ThresholdStoppingCondition
import org.grouplens.lenskit.iterative.StoppingThreshold
import org.grouplens.lenskit.iterative.RegularizationTerm
import org.grouplens.lenskit.transform.threshold.ThresholdValue

for (beta in [3]) {
    for (lambda in [0.5]) {
//        algorithm("SLIM-Norm") {
//            attributes["Beta"] = beta
//            attributes["lambda"] = lambda
//
//            bind ItemScorer to SLIMItemScorer
//
//            set MinItemWeight to 0.000001
//            set ModelSize to 100
//
////        bind SLIMBuildContext toProvider SLIMBuildContextProvider
//            bind UserVectorNormalizer to BaselineSubtractingUserVectorNormalizer
//            within (UserVectorNormalizer) {
//                bind (BaselineScorer, ItemScorer) to ItemMeanRatingItemScorer
//            }
//
//            bind StoppingCondition to ThresholdStoppingCondition
//            set StoppingThreshold to 1.0e-2
//
//            set RidgeRegressionTerm to beta
//            set RegularizationTerm to lambda
//        }

        algorithm("SLIM") {
            attributes["Beta"] = beta
            attributes["lambda"] = lambda

            bind ItemScorer to SLIMItemScorer

            set MinItemWeight to 0.000001
            set ModelSize to 100

//        bind SLIMBuildContext toProvider SLIMBuildContextProvider
//            bind UserVectorNormalizer to BaselineSubtractingUserVectorNormalizer
//            within (UserVectorNormalizer) {
//                bind (BaselineScorer, ItemScorer) to ItemMeanRatingItemScorer
//            }

            bind StoppingCondition to ThresholdStoppingCondition
            set StoppingThreshold to 1.0e-2

            set RidgeRegressionTerm to beta
            set RegularizationTerm to lambda
//            set MinCommonUsers to 2
            bind (ItemSimilarityThreshold, Threshold) to RealThreshold
            set ThresholdValue to -1
        }
    }

}


