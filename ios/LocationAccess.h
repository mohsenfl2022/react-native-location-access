
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNLocationAccessSpec.h"

@interface LocationAccess : NSObject <NativeLocationAccessSpec>
#else
#import <React/RCTBridgeModule.h>

@interface LocationAccess : NSObject <RCTBridgeModule>
#endif

@end
